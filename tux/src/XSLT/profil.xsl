<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : profil.xsl
    Created on : 16 novembre 2021, 03:15
    Author     : zodji
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
               xmlns:pf = "http://myGame/tux" version="1.0">
    
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>profil.xsl</title>
                <link rel="stylesheet" type="text/css" href="../css/style.css" media="screen"/>
            </head>
            
            <body>
                <!--j'affiche en grand caractere et en gras ' information du joueur'-->
                 <h1>
                    <b>INFO JOUEUR</b>
                </h1>
                <!-- pour chaque noeud profil-->
                 <xsl:for-each select = "//pf:profil" >
                     
                     <!--on recupere le nom , l'avatar  et l'anniversaire-->
                     
                      
                        
                    <p>  
                        <b>Nom:</b> 
               
                        <xsl:value-of select="pf:nom"/>
                           <br/>     
                           <b>Avatar:</b>
                        <xsl:value-of select="pf:avatar"/>
                        <br/>
                        <b>Anniversaires:</b>
                        <xsl:value-of select="pf:anniversaire"/>
                    </p>
                     <!--recuperaztion des informations d'une partie-->
                    <h3>Parties</h3>
                    <!--on creer un tableau qui prend la taille de l'ecran de contour 1 et on stocke les information puis on centre ces information --> 
                        <table>
                            <th>Date</th>
                            <th>Temps</th>
                            <th>Mot</th>
                            <th>Trouvé</th> 
                            <xsl:for-each select = "//pf:partie" >
                                <tr>
                                    <td align = "center" >
                                        <xsl:value-of select="@date"/>
                                    </td>
                                    <td align = "center">
                                        <xsl:value-of select="pf:temps"/>
                                    </td>  
                                    <td align = "center">
                                        <xsl:value-of select="pf:mot"/>
                                    </td>
                                    <td align = "center" >
                                        <xsl:value-of select="@trouvé"/>
                                    </td>  
                                </tr>
                            </xsl:for-each>
                        </table>
                        
                           
               
                
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
