<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" omit-xml-declaration="yes" media-type="text/html" />

    <xsl:template match="/">
        <html lang="en">
            <head>
                <meta charset="UTF-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <title>Población en distritos de Lorca</title>
            </head>
            <body>


                <h1>Población en distritos de Lorca</h1>

                <xsl:for-each select="estadistica-edad-sexo-distrito/item_edad">
                    <h2>
                        Edad:
                        <xsl:value-of select="edad" />
                    </h2>
                    <ul>
                        <li>
                            Hombres en distrito 1:
                            <xsl:value-of select="hombres_1" />
                        </li>
                        <li>
                            Mujeres en distrito 1:
                            <xsl:value-of select="mujeres_1" />
                        </li>
                        <li>
                            Hombres en distrito 2:
                            <xsl:value-of select="hombres_2" />
                        </li>
                        <li>
                            Mujeres en distrito 2:
                            <xsl:value-of select="mujeres_2" />
                        </li>
                    </ul>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>               