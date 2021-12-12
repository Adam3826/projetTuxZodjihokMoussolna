<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : dico.xsl
    Created on : 16 novembre 2021, 03:14
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
                <title>dictionnaire trié selon alphabet</title>
                <link rel="stylesheet" type="text/css" href="../css/style.css" media="screen"/>
            </head>
            <body>
                
                <h1>
                    <b>MOTS TRIE DU DICTIONNAIRE</b>
                </h1>
                
                <table>
                    <tr>
                        <th>Lest Mots triés selon l'alphabet</th>
                    </tr>
                    <tr>
                    <xsl:apply-templates select="/dic:dictionnaire/dic:mot">

                       
                        <xsl:sort  order="ascending" select="."/>
                    </xsl:apply-templates>
                    </tr>
                </table>
    
    
                    <xsl:template match="dic:mot">
                        <tr>
                            <td>
                        
                                <xsl:value-of select="."/>
                            </td>
                        </tr>
                    </xsl:template>

                  
            </body>
        </html>
    </xsl:template>
  
</xsl:stylesheet>