// our study group: Da wang, Yi Qiu, Qiang Wan
// load .txt file
var file_read = require('fs');

var filename = process.argv[2];
if (filename == undefined) {
	var filename = "pg45.txt";
	console.log('No input file, use the defaule .txt file');
}	
console.log("Strat to load the file: " + filename);


// read the content from .txt file
file_read.readFile(filename, function(err, data) {
	
	if (err) {
       return console.error(err);
   }
	// .txt file content
	var content;
	content = data.toString();
	
	console.log("System has loaded the .txt file");
	
	var count_line = 0; // record the line
	var count_word = 0; // record the word
	
	
	// Start to count the line of file
	var reg = new RegExp("\n", 'g');
	// since it would ignore the last line, so we have to add 1 line 
	// in result.
	count_line = content.match(reg).length + 1;
	
	console.log('-----------------------------')
	console.log("The file Information")
	
	
	// Start Count the word
	var appearance = {}; // record appearence
	var word_list = []; // record real word
	var tempcontent = content;
	tempcontent.split('\n').forEach(function(element) {
			element = element.replace(/[.,?!;()"--]/g, " ");
			element = element.replace(/\s+/g, " ");
			element = element.toLowerCase();
			var temp_word_list = element.split(' ');
			count_word += temp_word_list.length;
			temp_word_list.forEach(function(element) {
				// since there are useless element in the article
				if (element == '') {
					count_word = count_word - 1;
				}
				else {
					// if the word in the map, just plus 1
					if (appearance.hasOwnProperty(element)) {
						appearance[element]++;
					}
					// if not, add a map
					else {
						appearance[element] = 1;
					}
					word_list.push(element);
				}
			}, this);
	}, this);
	
	// sort the word by their number of appearance
	var sort_word_list = new Array();
	for (var key of Object.keys(appearance).sort()) {
		sort_word_list.push({word: key, appearance: appearance[key]});
	}
	sort_word_list.sort(function(a, b) {
		return b.appearance - a.appearance;
	});
	
	// Start deal with the trigram, put each 3 element into a trigrams
	var trigrams = {};
	for (var i = 0; i < word_list.length; i++) {
		var temp_tri = word_list.slice(i, i+3).join(' ');
		if (trigrams.hasOwnProperty(temp_tri)) {
			trigrams[temp_tri]++;
		}
		else {
			trigrams[temp_tri] = 1;
		}
	}
	var sort_list_trigrams = [];
	for (var key of Object.keys(trigrams).sort()) {
		sort_list_trigrams.push({trigram: key, appearance: trigrams[key]});
	}
	sort_list_trigrams.sort(function(a, b) {
		return b.appearance - a.appearance;
	});
	
	console.log('Number of Word: ' + count_word);
	console.log('Number of Line: ' + count_line);
	console.log('-----------------------------');
	console.log('Ten most common trigrams');
	for (var i = 0; i < 10; i++) {
		console.log(sort_list_trigrams[i]);
	}
	console.log('-----------------------------');
	console.log('Edit distances between the most common trigram and the next ten most common trigrams')
	// Start compute the Edit distance for each trigram
	for (var i = 1; i < 11; i++) {
		var most = sort_list_trigrams[0].trigram;
		var temp = sort_list_trigrams[i].trigram;
		console.log("[" + most + ']' + ' and '
					+ '[' + temp + '] : ' + edit_distance(most, temp));
	}
	console.log('-----------------------------');
	
	// generate the HTML file
	var htmlhead = '<html><head><title>' 
					+ filename 
					+ ' Statistics Result</title><head>';
	htmlhead += '<body><h1>' + filename + ' Statistics Result</h1>';
	htmlhead += '<hr />';
	htmlhead += '<h2>Basic Information</h2>';
	htmlhead += '<h3>' + 'Number of Word: ' + count_word + '</h2>';
	htmlhead += '<h3>' + 'Number of Line: ' + count_line + '</h2>';
	htmlhead += '<hr />';
	// Ten most common trigrams
	htmlhead += '<h2>Ten most common trigrams</h2>'
	htmlhead += '<table border="1">'
	htmlhead += '<tr><td> Trigram </td> <td> Appearance </td></tr>';
	for (var i = 0; i < 10; i++) {
		htmlhead += '<tr>';
		htmlhead += '<td>' + sort_list_trigrams[i].trigram + '</td>';
		htmlhead += '<td>' + sort_list_trigrams[i].appearance + '</td>';
		htmlhead += '</tr>';
	}
	htmlhead += '</table>'
	htmlhead += '<hr />';
	// print the Edit Distance
	htmlhead += '<h2>Edit distances between the most common trigram and the next ten most common trigrams</h2>'
	htmlhead += '<table border="1">'
	htmlhead += '<tr><td>The Most Common Trigram</td><td>Compare Trigram</td><td>Edit distance</td></tr>';
	for (var i = 1; i < 11; i++) {
		var most = sort_list_trigrams[0].trigram;
		var temp = sort_list_trigrams[i].trigram;
		htmlhead += '<tr>';
		htmlhead += '<td>' + most + '</td>';
		htmlhead += '<td>' + temp + '</td>';
		htmlhead += '<td>' + edit_distance(most, temp) + '</td>';
		htmlhead += '</tr>';
	}
	htmlhead += '</table>'
	htmlhead += '<hr />';
	
	// print the Word Frequency
	;
	htmlhead += '<h2>Word Frequency</h2>'
	htmlhead += '<table border="1">'
	htmlhead += '<tr><td>Word</td><td>Number of Appearance</td></tr>';
	for (var i = 0; i < sort_word_list.length; i++) {
		htmlhead += '<tr>';
		htmlhead += '<td>' + sort_word_list[i].word; + '</td>';
		htmlhead += '<td>' + sort_word_list[i].appearance + '</td>';
		htmlhead += '</tr>';
	}
	htmlhead += '</table>'
	htmlhead += '<hr />';
	
	htmlhead += '</body></html>';
	
	console.log("The HTML file has already generated");
	
    file_read.writeFile(filename.split('.')[0] + '_Statistics.html', htmlhead, function(err){
        if (err){
            return console.error(err);
        }
    });
	
} );

	// compute the Edit distance
function edit_distance(longstring, shortstring) {
	if (longstring == shortstring)
            return 0;
        if (shortstring.length == 0)
            return longstring.length;
        if (longstring.length == 0)
            return shortstring.length;
        var longform = new Array(shortstring.length + 1);
        var shortform = new Array(shortstring.length + 1);
        for (var i = 0; i < longform.length; i++)
            longform[i] = i;
        for (var i = 0; i < longstring.length; i++) {
            shortform[0] = i + 1;
            
            for (var j = 0; j < shortstring.length; j++) {
                var cost = 1;
                if(longstring[i] == shortstring[j])
                    cost = 0;
                shortform[j + 1] = Math.min(longform[j] + cost, shortform[j] + 1,
                        longform[j + 1] + 1);
            }
            for (var j = 0; j < longform.length; j++) {
                longform[j] = shortform[j];
            }
        }
        return shortform[shortstring.length];
}