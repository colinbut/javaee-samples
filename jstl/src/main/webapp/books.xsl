<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html" indent="yes"></xsl:output>

	<xsl:template match="/">
		<html>
			<body>
				<xsl:apply-templates/>
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="books">
		<table border="1" width="100%">
			<xsl:for-each select="book">
				<tr>
					<td>
						<b><xsl:value-of select="name"></xsl:value-of></b>
					</td>
					<td>
						<i><xsl:value-of select="author"></xsl:value-of></i>
					</td>
					<td>
						<xsl:value-of select="price"></xsl:value-of>
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>
	
</xsl:stylesheet>