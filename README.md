Learn a few advanced reduction patterns: flatten allows you to merge a set of arrays into a single array, the dreaded flatmap allows you to convert an array of objects into an array of arrays which then get flattened, and reduceRight allows you to invert the order in which your reducer is applied to your input values.
last updated: 2016/09/08 

var data = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
var flattenedData = data.reduce(function(acc, value) {
  return acc.concat(value);
}, []);

var input = [
  {
    title: "Batman Begins",
    year: 2005,
    cast: [
      "Christian Bale",
      "Michael Caine",
      "Liam Neeson",
      "Katie Holmes",
      "Gary Oldman",
      "Cillian Murphy"
    ]
  },
  {
    title: "The Dark Knight",
    year: 2008,
    cast: [
      "Christian Bale",
      "Heath Ledger",
      "Aaron Eckhart",
      "Michael Caine",
      "Maggie Gyllenhal",
      "Gary Oldman",
      "Morgan Freeman"
    ]
  },
  {
    title: "The Dark Knight Rises",
    year: 2012,
    cast: [
      "Christian Bale",
      "Gary Oldman",
      "Tom Hardy",
      "Joseph Gordon-Levitt",
      "Anne Hathaway",
      "Marion Cotillard",
      "Morgan Freeman",
      "Michael Caine"
    ]
  }
];

var stars = input.reduce(function(acc, value) {
  value.cast.forEach(function(star) {
    if (acc.indexOf(star) === -1) {
      acc.push(star);
    }
  });

  return acc;
}, []);

var data = [1, 2, 3, 4, "5"];
var sum = data.reduceRight(function(acc, value, index) {
  console.log(index);
  return acc + value;
}, 0);

console.log(sum);

Learn how to use the reduce function on javascript arrays to transform a list of values into something else. In this introduction we'll be taking a list of numbers and reducing them into a sum.

var data = [15, 3, 20];

var reducer = function(accumulator, item) {
  return accumulator + item;
};

var initialValue = 0;

var total = data.reduce(reducer, initialValue);

console.log("The sum is", total);

We'll look at using array.reduce to transform an array of strings into an object that counts the occurrence of each string in the array.
var votes = [
  "angular",
  "angular",
  "react",
  "react",
  "react",
  "angular",
  "ember",
  "react",
  "vanilla"
];

var initialValue = {};

var reducer = function(tally, vote) {
  if (!tally[vote]) {
    tally[vote] = 1;
  } else {
    tally[vote] = tally[vote] + 1;
  }

  return tally;
};

var result = votes.reduce(reducer, initialValue);

console.log(result);

ntroducing Reduce: Common Patterns

 8:32  JavaScript lesson by mykola bilokonsky
Learn how two common array functions - map() and filter() - are syntactic sugar for reduce operations. Learn how to use them, how to compose them, and how using reduce can give you a big performance boost over composing filters and maps over a large data set.
        var data = [1, 2, 3];
var doubled = data.reduce(function(acc, value) {
  acc.push(value * 2);

  return acc;
}, []);

var doubleMapped = data.map(function(item) {
  return item * 2;
});

var data2 = [1, 2, 3, 4, 5, 6];
var evens = data2.reduce(function(acc, value) {
  if (value % 2 === 0) {
    acc.push(value);
  }

  return acc;
}, []);

var evenFiltered = data2.filter(function(item) {
  return (item % 2 === 0);
});

var filterMapped = data2.filter(function(value) {
  return value % 2 === 0;
}).map(function(value) {
  return value * 2;
});

var bigData = [];
for (var i = 0; i < 1000000; i++) {
  bigData[i] = i;
}

// console.time('bigData');
var filterMappedBigData = bigData.filter(function(value) {
  return value % 2 === 0;
}).map(function(value) {
  return value * 2;
});
// console.timeEnd('bigData');

// console.time('bigDataReduce');
var reducedBigData = bigData.reduce(function(acc, value) {
  if (value % 2 === 0) {
    acc.push(value * 2);
  }
  return acc;
}, []);
// console.timeEnd('bigDataReduce');
Advanced Reduce: Additional Reducer Arguments

 4:47  JavaScript lesson by mykola bilokonsky
Sometimes we need to turn arrays into new values in ways that can't be done purely by passing an accumulator along with no knowledge about its context. Learn how to reduce an array of numbers into its mathematical mean in a single reduce step by using the optional index and array reducer arguments
function reducer(accumulator, value, index, array) {
  var intermediaryValue = accumulator + value;

  if (index === array.length - 1) {
    return intermediaryValue / array.length;
  }
Advanced Reduce: Common Mistakes

 4:17  JavaScript lesson by mykola bilokonsky
A programmer left her accumulator's initial value undefined - you won't believe what happened next!

  return intermediaryValue;
}

var data = [1, 2, 3, 3, 4, 5, 3, 1];
var mean = data.reduce(reducer, 0);

console.log(mean);
Advanced Reduce: Flatten, Flatmap and ReduceRight

 8:06  JavaScript lesson by mykola bilokonsky
Learn a few advanced reduction patterns: flatten allows you to merge a set of arrays into a single array, the dreaded flatmap allows you to convert an array of objects into an array of arrays which then get flattened, and reduceRight allows you to invert the order in which your reducer is applied to your input values.
var data = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
var flattenedData = data.reduce(function(acc, value) {
  return acc.concat(value);
}, []);

var input = [
  {
    title: "Batman Begins",
    year: 2005,
    cast: [
      "Christian Bale",
      "Michael Caine",
      "Liam Neeson",
      "Katie Holmes",
      "Gary Oldman",
      "Cillian Murphy"
    ]
  },
  {
    title: "The Dark Knight",
    year: 2008,
    cast: [
      "Christian Bale",
      "Heath Ledger",
      "Aaron Eckhart",
      "Michael Caine",
      "Maggie Gyllenhal",
      "Gary Oldman",
      "Morgan Freeman"
    ]
  },
  {
    title: "The Dark Knight Rises",
    year: 2012,
    cast: [
      "Christian Bale",
      "Gary Oldman",
      "Tom Hardy",
      "Joseph Gordon-Levitt",
      "Anne Hathaway",
      "Marion Cotillard",
      "Morgan Freeman",
      "Michael Caine"
    ]
  }
];

var stars = input.reduce(function(acc, value) {
  value.cast.forEach(function(star) {
    if (acc.indexOf(star) === -1) {
      acc.push(star);
    }
  });

  return acc;
}, []);

var data = [1, 2, 3, 4, "5"];
var sum = data.reduceRight(function(acc, value, index) {
  console.log(index);
  return acc + value;
}, 0);

console.log(sum);
Advanced Reduce: Composing Functions with Reduce

 8:19  JavaScript lesson by mykola bilokonsky
Learn how to use array reduction to create functional pipelines by composing arrays of functions.
last updated: 2016/09/08 
function increment(input) { return input + 1;}
function decrement(input) { return input - 1; }
function double(input) { return input * 2; }
function halve(input) { return input / 2; }

var initial_value = 1;

var pipeline = [
  increment,
  increment,
  increment,
  double,
  increment,
  increment,
  halve
];

var final_value = pipeline.reduce(function(acc, fn) {
  return fn(acc);
}, initial_value);

var reversed = pipeline.reduceRight(function(acc, fn) {
  return fn(acc);
}, initial_value)

console.log(final_value, reversed);

Advanced Reduce: Safe Nested Object Inspection

 6:29  JavaScript lesson by mykola bilokonsky
A common problem when dealing with some kinds of data is that not every object has the same nested structure. lukeskywalker.parents.father.isjedi works, but anakinskywalker.parents.father.isjedi throws an exception, because anakin_skywalker.parents.father is undefined. But we can reduce a path to provide safe default values and avoid exceptions when walking the same path on non-homogenous objects - watch to learn how! :)
last updated: 2016/06/21 
var luke = {
  name: "luke skywalker",
  jedi: true,
  parents: {
    father: {
      jedi: true
    },
    mother: {
      jedi: false
    }
  }
}

var han = {
  name: "han solo",
  jedi: false,
  parents: {
    father: {
      jedi: false
    },
    mother: {
      jedi: false
    }
  }
}

var anakin = {
  name: "anakin skywalker",
  jedi: true,
  parents: {
    mother: {
      jedi: false
    }
  }
}

var characters = [luke, han, anakin];

function fatherWasJedi(character) {
  var path = "parents.father.jedi";
  return path.split(".").reduce(function(obj, field) {
    if (obj) {
      return obj[field];
    }

    return false;
  }, character);
}

characters.forEach(function(character) {
  console.log(character.name + "'s father was a jedi:", fatherWasJedi(character));
});

The Array forEach method

 4:03  JavaScript lesson by Jafar Husain
Most JavaScript developers are familiar with the for loop. One of the most common uses of the for loop is to iterate through the items in an array. In this lesson, we will learn how to replace the for loop with the Array's forEach method - and shorten your code in the process.
function getStockSymbols(stocks) {
  var symbols = [];
  
  stocks.forEach(function(stock) {
    symbols.push(stock.symbol);
  });
  
  return symbols;
}

var symbols = getStockSymbols([
  { symbol: "XFX", price: 240.22, volume: 23432 },
  { symbol: "TNZ", price: 332.19, volume: 234 },
  { symbol: "JXJ", price: 120.22, volume: 5323 },
]);

console.log(JSON.stringify(symbols));
 Create a Shallow Copy of an Array with Slice

 9:15  JavaScript lesson by Shane Osbourne
Array slice creates a shallow copy of an array. In this lesson we cover, in detail, exactly what a 'shallow' copy is and how it can trip people up. We go on to look at examples that show to how to copy only the first item, the last item and even how to copy a sub-section of an array excluding the first and last. We end the lesson with a practical example that shows how slice fits into a workflow that contains other array methods such as map & reduce.
// Array.prototype.slice();
// see CONSOLE!

var person  = {
    name: 'shane-osbourne'
};

var filters = {
    'deslugify': x => x.replace('-', ' '),
    'uppercase': x => x.toUpperCase()
};

var input    = 'name | deslugify | uppercase'; // SHANE OSBOURNE
var sections = input.split('|').map(x => x.trim()); // [name, deslugify, uppercase]
var ref      = person[sections[0]];
var output   = sections
    .slice(1)
    .reduce((prev, next) => {
        if (filters[next]) {
            return filters[next].call(null, prev);
        }
        return prev;
    }, ref);

console.log(output);

Check if a Value is in an Array with indexOf

 5:21  JavaScript lesson by Shane Osbourne
indexOf is used to search for a value or reference inside of an array. In this lesson we first look at what values are returned when a search is successful vs when it's unsuccessful. Then we move onto a technique that shows how to use the return value to create a boolean flag that can be checked easily. We end by filtering 1 array based on the existence of a value in a whitelist array.
// Array.prototype.indexOf();
// see console for output!

var whitelist = ['.css', '.js'];

var events = [
  {
    file: 'css/core.css'
  },
  {
    file: 'js/app.js'
  },
  {
    file: 'index.html'
  }
];

var filtered = events.filter(event => {
  var ext = event.file.substr(event.file.lastIndexOf('.'));
  return whitelist.indexOf(ext) > -1;
});

console.log(filtered);

Combine Values of an Array into a String with Join

 4:42  JavaScript lesson by Shane Osbourne
The join() method joins all elements of an array into a string. In this lesson we first look at why join is often a better option than regular string concatenation. Then we move onto an example which shows a simple way of storing lines of text in an array and outputting them with a new line separator and we finish by looking at ways to chain multiple array methods together.
// see console for output

var name = 'shane osbourne';

var upper = name.split(' ') // [shane, osbourne]
.map(x => x.charAt(0).toUpperCase() + x.slice(1)) // [Shane, Osbourne]
.join(' ');

console.log(upper);
The Array map method

 3:02  JavaScript lesson by Jafar Husain
One very common operation in programming is to iterate through an Array's contents, apply a function to each item, and create a new array containing the results. For example, let's say you wanted to loop through an array of stock objects and select only the name for display on screen. In this lesson we will demonstrate how to use the Array's map method to easily perform this operation with less code than a loop would require.
function getStockSymbols(stocks) {
  return stocks.map(function(stock) {
    return stock.symbol;
  })
}

var symbols = getStockSymbols([
  { symbol: "XFX", price: 240.22, volume: 23432 },
  { symbol: "TNZ", price: 332.19, volume: 234 },
  { symbol: "JXJ", price: 120.22, volume: 5323 },
]);

console.log(JSON.stringify(symbols));
The Array filter method

 4:42  JavaScript lesson by Jafar Husain
One very common operation in programming is to iterate through an Array's contents, apply a test function to each item, and create a new array containing only those items the passed the test. For example, let's say you wanted to loop through an array of stocks and select only those with the price larger than a certain value. In this lesson we will demonstrate how to use the Array's filter method to easily perform this operation with less code than a loop would require.
function getStocksOver(stocks, minPrice) {
  return stocks.filter(function(stock) {
    return stock.price >= minPrice;
  })
}

var expensiveStocks = getStocksOver([
  { symbol: "XFX", price: 240.22, volume: 23432 },
  { symbol: "TNZ", price: 332.19, volume: 234 },
  { symbol: "JXJ", price: 120.22, volume: 5323 },
],
150.00);

console.log(JSON.stringify(expensiveStocks));
Chaining the Array map and filter methods

 3:05  JavaScript lesson by Jafar Husain
Both map and filter do not modify the array. Instead they return a new array of the results. Because both map and filter return Arrays, we can chain these functions together to build complex array transformations with very little code. Finally we can consume the newly created array using forEach. In this lesson, we will learn how to build nontrivial programs without using any loops at all.
last updated: 2016/09/08 
var stocks = [
  { symbol: "XFX", price: 240.22, volume: 23432 },
  { symbol: "TNZ", price: 332.19, volume: 234 },
  { symbol: "JXJ", price: 120.22, volume: 5323 },
];

var filteredStockSymbols = 
  stocks.
    filter(function(stock) {
      return stock.price >= 150.00;
    }).
    map(function(stock) {
      return stock.symbol;
    })

filteredStockSymbols.forEach(function(symbol) {
  console.log(symbol);
})
Use Concat to Add Values to an Array

 4:38  JavaScript lesson by Shane Osbourne
Concat creates a shallow copy of an existing array that includes any arguments you pass to it. In this lesson, we look at using concat for adding additional values to an array then cover some more useful features such as accepting other arrays as arguments & how to chain concat with other array methods such as forEach
// Array.prototype.concat();
// See console for output!

var people = [
  {
    name: 'Shane'
  },
  {
    name: 'Sally'
  }
];

var people2 = [
  {
    name: 'Simon'
  },
  {
    name: 'Ben'
  }
];

people2.concat(people2)
  .forEach(function (person) {
    console.log(person.name);
  });
  
  Create an Array concatAll method

 4:17  JavaScript lesson by Jafar Husain
In addition to flat Arrays, programmers must often deal with nested Arrays. For example let's say we have an Array of stock exchanges, each of which is represented by an array of all the stocks listed on that exchange. If we were looking for a stock that matched a certain criteria, we would first need to loop through all of the exchanges, and then all of the stocks within.

In these situations, most developers would nest two loops. However in this lesson we will write a new Array function "concatAll" which will automatically flatten nested arrays buy one dimension. This will remove the need to ever use a nested loop to flatten a nested array.
        var exchanges = [
  [
      { symbol: "XFX", price: 240.22, volume: 23432 },
      { symbol: "TNZ", price: 332.19, volume: 234 }
    ],
  [
      { symbol: "JXJ", price: 120.22, volume: 5323 },
      { symbol: "NYN", price: 88.47, volume: 98275 }
    ]
];


Array.prototype.concatAll = function() {
  var results = [];
  
  this.forEach(function(subArray) {
    subArray.forEach(function(item) {
      results.push(item);    
    });
  });  

  return results;
};


var stocks =  exchanges.concatAll();
    
stocks.forEach(function(stock) {       
  console.log(JSON.stringify(stock));  
});
Refactoring: Array.prototype by example [filter, some, forEach]

 5:42  JavaScript lesson by Erik Aybar
Refactoring is a great opportunity to learn and we have an existing Javascript function that is lengthy, hard to understand, and overcomplicated. We'll take a look at putting some of Javascript's built in Array.prototype methods to use to help us clean this up and learn by example through refactoring.

By taking a few minutes to refactor this existing code, we can get a glimpse at how we can harness the power of the Array and lean on some built in Array functions available to us in Javascript's core without any added utility libraries.

In this lesson we touch on just a few of the Array methods:

Array.prototype.forEach
Array.prototype.filter
Array.prototype.some.
var Inbox = {
  
  /**
   * An array of message objects
   * Example: {id: 1, from: 'Joe Schmoe', subject: 'Hello There', flagged: false}
   */
  messages: [],
  
  /**
   * Given an array of "selected message ids", decide whether to flag OR unflag them
   *
   * If all selected messages are flagged, unflag them.
   * If none selected messages are flagged, flag them.
   * If any selected messages are not flagged, flag them.
   * 
   * @param selectedIds
   * @return {boolean}
   */
  shouldFlag: function(selectedIds) {
    
    return this.messages
      .filter(message => selectedIds.indexOf(message.id) !== -1)
      .some(message => !message.flagged);

  },
  
  
  /**
   * BEFORE refactoring
   */
  oldShouldFlag: function(selectedIds) {
    // Assume don't flag
    var shouldFlagMessages = false;
    // Keep track of how many are flagged and not flagged
    var flaggedCount = 0;
    var unFlaggedCount = 0;

    // Get only the messages we care about
    var messagesInQuestion = [];
    for (var i = 0; i < this.messages.length; i++) {
      if (selectedIds.indexOf(this.messages[i].id) !== -1)
        messagesInQuestion.push(this.messages[i]);
    }

    // Determine the number of flagged messages vs. unflagged messages in the set
    for (var i = 0; i < messagesInQuestion.length; i++) {
      if (messagesInQuestion[i].flagged) {
        flaggedCount++;
      } else {
        unFlaggedCount++;
      }
    }

    // Only flag the messages if there are no flagged messages 
    // OR there are messagesInQuestion present that are not flagged
    if (flaggedCount === 0 || unFlaggedCount !== 0)
      shouldFlagMessages = true;

    return shouldFlagMessages;
  }
  
};


/**
 * Setup data, usages, and verify expected outcomes
 */

Inbox.messages = [
  {
    id: 123,
    from: "John Doe",
    flagged: false,
    subject: "Please Read Me"
  },
  {
    id: 124,
    from: "Mary Jane",
    flagged: true,
    subject: "Not so important..."
  },
  {
    id: 125,
    from: "Bill Bob",
    flagged: false,
    subject: "Spam Content"
  },
  {
    id: 126,
    from: "Josh Josherson",
    flagged: true,
    subject: "RE: Your Request"
  },
  {
    id: 127,
    from: "Kate Katerson",
    flagged: true,
    subject: "Just Checking in"
  }
];

// Pretend these are Jasmine tests ;P
function assertShouldFlag(expectation, selectedIds, description) {
  var result  = Inbox.shouldFlag(selectedIds);
  var message = (result === expectation)
    ? "Pass!"
    : "Failed...";
  console.log(
    description,
    message + 
    " Expected " + expectation + " got " + result + " with " +
    JSON.stringify(selectedIds) + "\n"
  );
}

console.clear();
console.log(Math.random());

assertShouldFlag(false, [124, 126],
                "If all selected messages are flagged, unflag them.");

assertShouldFlag(true, [123, 125],
                "If none selected messages are flagged, flag them.");

assertShouldFlag(true, [123, 124, 126, 127],
                "If any selected messages are not flagged, flag them.");

Converting an array-like object into an Array with Array.from()

 2:19  JavaScript lesson by Trevor Miller
Array.from() lets you convert an "iterable" object (AKA an array-like object) to an array. In this lesson, we go over grabbing DOM nodes and turing them into an array so that we can use methods like Array.filter() and Array.forEach() on them.
last updated: 2016/09/02 
Share this lesson: Facebook Twitter Google+
Code
Discuss
const products =
  Array.from(document.querySelectorAll('.product'));

products
  .filter(product => parseFloat(product.innerHTML) < 10)
  .forEach(product => product.style.color = 'red');
  Introducing the Observable

 11:59  JavaScript lesson by Jafar Husain
In this lesson we will get introduced to the Observable type. An Observable is a collection that arrives over time. Observables can be used to model events, asynchronous requests, and animations. Observables can also be transformed, combined, and consumed using the Array methods we learned in the previous lessons. We can write powerful and expressive asynchronous programs using the few simple methods we've learned so far.
var Observable = Rx.Observable;

var button = document.getElementById('button');
/*
var handler = function(e) {
	alert('clicked');
	button.removeEventListener('click', handler);
};

button.addEventListener('click', handler);
*/

var clicks = Observable.fromEvent(button, 'click');

var subscription = 
	clicks.forEach(
		function onNext(e) {
			alert('clicked');
			subscription.dispose();
		},
		function onError(error) {				 		
			console.log('ERROR!');
		},
		function onCompleted() {
			console.log("done");
		});
