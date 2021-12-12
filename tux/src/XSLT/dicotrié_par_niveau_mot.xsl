<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : dicotrié_par_niveau_mot.xsl
    Created on : 12 décembre 2021, 15:24
    Author     : zodji
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:dic='http://xml.netbeans.org/schema/dico'>
    <xsl:output method="html" encoding="utf-8"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
   
        <html>
            <head>
                <title>dictionnaire</title>
                <link rel="stylesheet" type="text/css" href="../css/style.css" media="screen"/>

            </head>
            <body>
                <h1>
                    <b>MOTS DU DICTIONNAIRE</b>
                </h1>
                <table>
                    <tr>
                        <th>Mots</th>
                        <th>Niveau</th>
                    </tr>
                    <tr>
                        <xsl:apply-templates select="/dic:dictionnaire/dic:mot">
                            <xsl:sort order = "ascending" select="@niveau"/>
                        </xsl:apply-templates>
                    
                    </tr>
                    
                </table> 
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="dic:mot">
        
        <tr>
            
            <td> 
                <xsl:value-of select="@niveau"/>
            </td>
            <td>
           
                <xsl:value-of select="."/>        
            
            </td>
            
        </tr>
    </xsl:template>
   
   

</xsl:stylesheet>


