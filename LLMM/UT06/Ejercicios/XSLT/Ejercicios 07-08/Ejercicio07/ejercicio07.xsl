<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" omit-xml-declaration="yes" media-type="text/html" />
    <xsl:template match="/">
        <xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
        <html lang="es">
            <head>
                <meta charset="UTF-8"/>
                <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
                <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
                <link rel="stylesheet" href="ejercicio07.css"/>
                <title>Examen</title>
            </head>
            <body>
                <header>
                    <h1>
                        <xsl:choose>
                            <xsl:when test="/quiz/question[@type='category']">
                                Test del aula virtual:
                                <xsl:call-template name="extraerTitulo">
                                    <xsl:with-param name="textoCategoria" select="/quiz/question[@type='category']/category/text"/>
                                </xsl:call-template>
                            </xsl:when>
                            <xsl:otherwise>
                                Test del aula virtual.
                            </xsl:otherwise>
                        </xsl:choose>
                    </h1>
                </header>
                <main>
                    <form method ="post" action="http://servidorwebclara.ga">
                        <xsl:for-each select="quiz/question[@type!='category']">
                            <!-- <xsl:variable name="numPregunta" select="count(preceding-sibling::question[@type!='category']) + 1"/> -->
                            <xsl:variable name="numPregunta" select="position()"/>
                            <div class="pregunta">
                                <h2>
                                    Pregunta <xsl:value-of select="$numPregunta"/>
                                </h2>
                                <div class="enunciado">



                                    <xsl:choose>
                                        <xsl:when test="questiontext/@format = 'html'">
                                            <xsl:value-of select="questiontext/text" disable-output-escaping="yes"/>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <p><xsl:value-of select="questiontext/@format"/></p>
                                        </xsl:otherwise>
                                    </xsl:choose>




                                    <xsl:if test="questiontext/file">
                                        <div>
                                            <img src="data:image/png;base64, {questiontext/file}" alt="" />
                                            <!-- <img alt="" >
                                                <xsl:attribute name="src">data:image/png;base64, <xsl:value-of select="questiontext/file"/></xsl:attribute>
                                            </img> -->
                                        </div>
                                    </xsl:if>




                                </div>
                                <div class="respuestas">
                                    <ul>
                                        <xsl:for-each select="answer">
                                            <!-- <xsl:variable name="numrespuesta" select="count(preceding-sibling::answer) + 1"/> -->
                                            <xsl:variable name="numrespuesta" select="position()"/>
                                            <li>
                                                <label> 
                                                    <input type="radio" name="pregunta{$numPregunta}" value="{$numrespuesta}"/>
                                                    
                                                    
                                                    <xsl:value-of select="text" disable-output-escaping="yes"/>
                                                </label>
                                            </li>
                                        </xsl:for-each>
                                    </ul>
                                </div>
                            </div>
                        </xsl:for-each>
                        <p>
                            <input type="submit" value="Enviar y terminar"/>
                        </p>
                    </form>
                </main>
                
            </body>
        </html>
    </xsl:template>
    
    <xsl:template name="extraerTitulo">
        <xsl:param name="textoCategoria"/>
        <xsl:variable name="resto" select="substring-after($textoCategoria, '/')"/>
        <xsl:choose>
            <xsl:when test="string-length($resto) = 0">
                <xsl:value-of select="$textoCategoria"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:call-template name="extraerTitulo">
                    <xsl:with-param name="textoCategoria" select="$resto"/>
                </xsl:call-template>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>


</xsl:stylesheet>