import urlparse
import urllib
import urllib2
from bs4 import BeautifulSoup
import re

url = "http://techcrunch.com/2015/11/02/equity-crowdfunding-is-on-its-way/"

# DFS
urls = [url] # stack of urls
visitied = [url] # history record of url

while len(urls) > 0:
	htmltext = urllib.urlopen(urls[0]).read()
	soup = BeautifulSoup(htmltext, "lxml")
	visitied.append(urls[0])
	print "Link: " + urls[0]
	urls.pop(0)
	count = 0
	for link in soup.findAll('a'):
		pat = re.compile(r'href="([^"]*)"')
		pat2 = re.compile(r'http')
		pat3 = re.compile(r'http://techcrunch.com/"([^"]*)"')
		content = soup.findAll('a')
		count = 0
		for item in content:
			h = pat.search(str(item))
			if h == None:
				break
			href = h.group(1)
			if pat2.search(href):
				ans = href
				if ans not in visitied and pat3.search(href):
					urls.append(ans)
					visitied.append(ans)