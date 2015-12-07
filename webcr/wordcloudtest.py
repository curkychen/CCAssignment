import matplotlib.pyplot as plt
from wordcloud import WordCloud
 
text = "zhengyu fasf fsffla flskjfh fsl fasfkjfldaf s faslfaskdfhlksfda  flaskdfkhsa s dfls afsf kslfskd  sfsd k fa"
 
wordcloud = WordCloud().generate(text)
img=plt.imshow(wordcloud)
plt.axis("off")
plt.show() 
 
#or save as png
img.write_png("wordcloud.png")