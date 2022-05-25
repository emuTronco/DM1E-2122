<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
    
    <xsl:output method="html" indent="yes" media-type="text/html"/>
    
    <xsl:template match="/">
        <html lang="es">
            <head>
                <meta charset="UTF-8"/>
                <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
                <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
                <link rel="stylesheet" href="estilos.css"/>
                <title>Listado de Pokemon</title>
            </head>
            <body>
                <header><h1>Listado de Pokemon</h1></header>
                <main>
                    <section>
                        <header><h2>Iniciales</h2></header>
                        <xsl:apply-templates select="/pokemons/pokemon[@class = 'initial']"/>
                    </section>
                    <section>
                        <header><h2>Legendarios</h2></header>
                        <xsl:apply-templates select="/pokemons/pokemon[@class = 'legendary']"/>
                    </section>
                </main>
                <footer></footer>
            </body>
        </html>
        
    </xsl:template>
    
    <xsl:template match="pokemon">
        <article>
            <h3>Pokemon <xsl:value-of select="name"/></h3>
            <xsl:apply-templates select="base_experience"/>
            <p>Estatura: <xsl:value-of select="height"/></p>
            <p>Peso: <xsl:value-of select="weight"/></p>
            <p>Imágenes</p>
            <img alt="Imagen de frente de {name}">
                <xsl:attribute name="src"><xsl:value-of select="sprites/front_default"/></xsl:attribute>
            </img>
            <img src="{sprites/back_default}" alt="Imagen de espaldas de {name}">
                <!-- <xsl:attribute name="src"><xsl:value-of select="sprites/back_default"/></xsl:attribute> -->
            </img>
            <p>
                <a href="{url}" target="_blank">Enlace a los datos de <xsl:value-of select="name"/></a>
            </p>
        </article>
    </xsl:template>
    <xsl:template match="base_experience">
        <p>
            <xsl:choose>
                <xsl:when test=". &lt; 100">
                    <xsl:attribute name="class">exp-baja</xsl:attribute>    
                </xsl:when>
                <xsl:when test=". >= 200">
                    <xsl:attribute name="class">exp-alta</xsl:attribute>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:attribute name="class">exp-media</xsl:attribute>
                </xsl:otherwise>
            </xsl:choose>
            Experiencia: <xsl:value-of select="."/>
        </p>
        
    </xsl:template>
    
</xsl:stylesheet>