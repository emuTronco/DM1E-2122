<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="3.0">
	<xsl:output method="html" omit-xml-declaration="yes" media-type="text/html" />
	<xsl:template match="/">
		<xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
		<html lang="es">
			<head>
				<meta charset="UTF-8" />
				<meta http-equiv="X-UA-Compatible" content="IE=edge" />
				<meta name="viewport" content="width=device-width, initial-scale=1.0" />
				<link rel="stylesheet" href="estilos.css" />
				<title>Examen</title>
			</head>
			<body>
				<header>
					<h1>
						<xsl:choose>
							<xsl:when test="/quiz/question[@type='category']">
								Test del aula virtual: <xsl:value-of select="tokenize(/quiz/question[@type='category']/category/text, '/')[last()]"/>
							</xsl:when>
							<xsl:otherwise>
                                Test del aula virtual.
                            </xsl:otherwise>
						</xsl:choose>
					</h1>
				</header>
				<main>
					<xsl:for-each select="quiz/question[@type!='category']">
						<xsl:variable name="numPregunta" select="count(preceding-sibling::question[@type!='category']) + 1" />
						<article>
							<h2>
								Pregunta
								<xsl:value-of select="$numPregunta" />
							</h2>
							<div class="enunciado">
								<xsl:choose>
									<xsl:when test="questiontext/@format = 'html'">
										<xsl:value-of select="questiontext/text" disable-output-escaping="yes" />
									</xsl:when>
									<xsl:otherwise>
										<p>
											<xsl:value-of select="questiontext/@format" />
										</p>
									</xsl:otherwise>
								</xsl:choose>
								<xsl:if test="questiontext/file">
									<div>
										<img src="data:image/png;base64, {questiontext/file}" alt="" />
									</div>
								</xsl:if>
							</div>
							<div class="respuestas">
								<ul>
									<xsl:for-each select="answer">
										<xsl:sort select="@fraction" order="descending" data-type="number" />
										<li>
											<xsl:if test="@fraction=100">
												<xsl:attribute name="class">correcta</xsl:attribute>
											</xsl:if>
											<div class="porcentaje">
												<xsl:value-of select="@fraction" />
												%
											</div>
											<xsl:value-of select="text" disable-output-escaping="yes" />
										</li>
									</xsl:for-each>
								</ul>
							</div>
						</article>
					</xsl:for-each>
				</main>

			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>