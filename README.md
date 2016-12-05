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
			subscription.disposedd();
		},
		function onError(error) {				 		
			console.log('ERROR!');
		},
		function onCompleted() {
			console.log("done");
		});


Using the map method with Observable

 3:45  JavaScript lesson by Jafar Husain
Like an array, Observable has a map method that allows us to transform a sequence into a new Observable.
Now that we've explained how you get data out of an Observable and how you can convert a DOM event into an Observable, let's take a look at how we can use the map function and the other functions to transform Observables into other Observables the same way we use map to transform Arrays into other Arrays.

What if I want to take this click stream and create a point stream? What I want to do is I want to take each one of the event objects that comes out of our click stream. I want to map it into the point, the (x, y) point at which the button was clicked.

If I want to take each item in that collection and I want to transform it into another item, I'm going to use the map method, just like I would if I was taking an Array of numbers and then map them and add one to each of them.

I'm going to map over this. I'm going to get out an event object. I'm going to return an object with an x that's equal to clientX and a y that's equal to the clientY property on the event object. That is going to create me another Observable.

I'm now going to change clicks to be points. I'm just going to subscribe to points instead of clicks. I'm going to alert. I'm going to change this now. It's no longer an event object. It's a point object. I'm going to now change my clicked message so we print out the point.

Now it should only print one point because we're still disposing of our subscription object as soon as the first one is clicked. As I click this, now we see the point on the screen where that button was clicked.

If I attempt to click more, nothing happens because after the first click, we unsubscribed. Just to drive the point home, if I delete this, it will just keep on printing out clicks. What I'll do is I'll put it back in here.

There's one more thing you need to understand about an Observable. An Observable is lazy. What do I mean when I say "Lazy"? Here, notice we created the points Observable by mapping over the clicks Observable. This is just one thing I want to drive home here.

When we map over Arrays, we get Arrays. When we filter Arrays, we get Arrays. When we concatAll Arrays, we get Arrays. When we map over Observables, we get Observables. When we filter Observables, we get Observables and so on and so forth.

As soon as you start with an Observable, you know you're going to have only Observables. As you call map and filter on that Observable, you're just going to create new Observables.

Having made that point, the other point that I want to make is that Observables are lazy. If I comment out...Notice I'm no longer forEach'ing over these points Observable. If I call "Click me," I want you to notice that nothing happens. As a matter of fact, addEventListener, under the hood, has not even been called by Observable.fromEvent.

The way Observable works is it waits until you call forEach to have any side effects, to carry out any side effects whatsoever. What we've done is we've really just built an Observable that promises that when you will call forEach on it, it will hook up an event listener.

When we map over that Observable, we've created another Observable that promises that when we forEach over it, it will forEach over the underlying data source, clicks, and then, as data arrives, will transform that data, using a projection function, into new data. Just simply creating Observables causes nothing to happen.

We have to forEach over the Observable in order for something to happen. That'll become clear,
 hovar Observable = Rx.Observable;

var button = document.getElementById('button');
/*
var handler = function(e) {
	alert('clicked');
	button.removeEventListener('click', handler);
};

button.addEventListener('click', handler);
*/

var clicks = Observable.fromEvent(button, 'click');

var points = 
	clicks.map(function(e) {
		return {x: e.clientX, y: e.clientY};
	});

var subscription = 
	points.forEach(
		function onNext(point) {
			alert('clicked:' + JSON.stringify(point));
			subscription.dispose();
		},
		function onError(error) {				 		
			console.log('ERROR!');
		},
		function onCompleted() {
			console.log("done");
		});
w that mechanism works, because later on, we're actually going to write our Eown Observable, from scratch, around a simple library. Once again, to drive the point home, I'll run this. We get the points that are clicked.
Welcome back to the End of the Loop. Last time we learned about the absorbable type. This is what we've been building up to thus far. We've been learning to program without loops so that we can use these methods and these ways of building complex programs on not just arrays, which are synchronous collections, but asynchronous collections like Observable.

The goal here is to teach you to learn to program without loops so that we can apply these methods to asynchronous programming later on, but first of all we have a few methods to learn and we have a few basic skills we need to really drive home and absorb in order to be successful when we move over to asynchronous programing, which is a good deal more complex than synchronous programing.

The first and most important is flattening. Now if you remember a few exercises, we did a flattening exercise in which we went through a array of exchanges and we collected up all of the stocks within each of those exchange where the price was larger than or equal to a hundred. Here's the program down here.


In order to flatten without loops what we need to use is the concat all method. The challenge, of course, is that concat all only works on two dimensional arrays, and in this case we have an array of objects which contain arrays.

How do we flatten? Well, we can't flatten that with concat all alone because it only works on arrays of arrays. However, by using map to transform each exchange into the stocks inside of that exchange and then filter those stocks for all those stocks where the price was larger than or equal to a hundred, we were able to use map to transform that array of objects that contain arrays into an array of arrays.

Then we can apply concat all to flatten it out. Finally we use For Each to consume the collection and do something with it, like log it out to the console. Let's check out to see if this works. We run it, and sure enough it does. We see only those stocks with a price larger than or equal to a hundred and the stock NYN is omitted.

This technique of flattening is great. It works. It's something that you're going to need to learn to become very, very familiar with as we go on and move towards async programing, but just to make a hundred percent sure that we really know what we're doing, we're going to try flattening not just two levels of data structure. We're going to try flattening three levels of data structure.

Let's imagine that instead of just an array of objects that are exchanges, each of which contain an array of stocks, we had one more level that we had an array of exchanges, each of which contains an array of stocks, but each one of those stocks contains not just one price but an array of close prices, meaning a particular date and a particular price that it closed at on that particular.

We have three levels. We have array of exchanges. We have an object that represents an exchange which contains an array of stocks. Within each stock we have array of close dates. Let's say that we want to grab the price of all of the stocks on Christmas Eve, the closing price of all the stocks on Christmas Eve. Let's just start, shall we?

I'm going to first start at the very top with exchanges. First I'm going to name the collection I'm creating. I'll call it Christmas Eve Closes. I'm going to first map over all of the exchanges. I'm just going to go ahead and move map to the next line here, because I fully expect there will be operators chained off of it. Then I'm going to map over all of the stocks in each exchange.

Now here is where a lot of developers make a mistake, and that's partly because we as developers aren't necessarily comfortable with dealing with multi-nested collections. We don't like going deep, deep down into collections like this, and so we try and get out of them as soon as possible.

What a lot of developers will do is, faced with this collection, they will just go ahead and filter the close's collection. They'll take stock closes, and they will filter it. They'll look for the close with the date of December and the day of 24th.

They'll assign it to a variable, and then they will want to return their results. In this case I'm going to return the symbol and the price of each stock on Christmas Eve. Where am I going to get the symbol from?

Notice that the stock has been introduced by a disclosure. This map function is going to get executed for every single stock, so I have access to the stock symbol right here. As for the price, I'm almost there. Notice that this Christmas Eve Closes is not just one item. It's actually array that contains one item. That's why I've named it pleural here.

This array will only ever contain one item because no matter how many closes there are, at least assuming this is only for the year 2014, there will only be one date in this collection that matches this criteria.

What a lot of developers will do is just go ahead and pull it out. What's wrong with this? This should work just fine, right? Here's the issue. Now you guys know about Observable. There are some things you just cannot do to an Observable, like synchronously pull a valuable out.

Observables are just like events. You can't simply block and wait for an event to give you an item. While it will work just fine for arrays, it will not work for observables and asynchronous data streams, so we're not going to do it.

Here's what we're going to do instead. We are going to go ahead and return the results of this filter. Instead of just pulling the first value out like so, how are we going to get a variable that is pointing to this object? It's easy. All we have to do is map over this array that contains only one item -- it will only contain the Christmas Eve Close -- and now we have our Christmas Eve Close.

Now inside of here I can return this object because I have access to all of the data that I need. This can be replaced with this. Really the trick to flattening deeply nested structures is to just keep nesting map expressions until you have a variable or function argument, when is basically the same thing here, a variable bound to every single item you need to create your result.

That's the first step in flattening any nested data structure. The last step -- and this is the trickiest --you've got to figure out how many levels of collection deep you are. What we've got here is we actually have a nested array. Christmas Eve Closes is not a flat array. It's a nested array.

Why is that? Well, it has to do with the way that map works. If you take a collection and you map over it, and for every item in that collection you return another collection, you will end up with a two dimensional collection. In this case we have this. Take a look at this code for a second.

If I map over every item in a collection and I just return a regular item, transform that item somehow, we get another flat collection or a collection with the same dimensions as the source collection. As soon as I return an array instead, we end up with a two dimensional collection.

If we notice, that's exactly what I'm doing here. I am mapping over all of the exchanges, and within that map expression I'm returning yet another array because the product of mapping over stocks will be yet another array. Then within this map expression I'm returning yet another array.

Because there are three nested map expressions, I am going to end up with a three dimensional collection. The first step is figuring out how many levels deep your collection is. The next step is to flatten it n-1 times.

If your collection is three dimensional, you need two concat alls. It also matters where you put the concat all. I can't put the concat all here because I want you to notice that this expression by itself is just a one dimensional collection. We're just taking an array of closes, filtering it, and then mapping it not into another collection but just into an object.

This expression, this subexpression by itself, is just a one dimensional collection, which means that concat all will err, will throw. You cannot concat all to a one dimensional collection. However, out here what I've done is for every stock I'm returning an array just like in this example up here.

For every item in an array I am returning yet another array. I therefore must have a two dimensional collection, so I use concat all. It will work on this because this subexpression is a two dimensional collection.

Notice that for every exchange we are returning an array. In this case now it's a flat array because we have applied concat all. So that means we have a two dimensional collection. We've gone from a three dimensional collection to a two dimensional collection. Now we just need one more concat all to flatten it into a flat, one dimensional collection.

Once we've built the collection that we want, Christmas Eve Closes, from the collection that we have, Exchanges, there's only one thing left to do, consume that collection and do something with the data. In this case I'm going to use For Each to consume the collection, and I am going to print it out to the console.

Now what we should expect to see is only the prices for those stocks, for all these stocks, on Christmas Eve. Let's give this a run. No? What did I miss? Oh, I compared get month to 12 instead of 11, and the month is base 0.

If I run this now we should see...we see price. We see the symbol for all of the stocks, and we see a price. Let's go and compare that price to see that it worked. $240.10 for XFX, $521.24 for TNZ, yes, that's the Christmas Eve date. $423.22 for JXJ and $16.82 for NYN.

As we can see, we've managed to flatten any nested data structure. All we need to do is to keep mapping until we have all of the data that we need bound through the closure arguments and then create our result, figure out how many levels deep we are, and apply concat all n-1 times. That's all there is to flattening. Stay tuned.
var exchanges = [
  { 
    name: "NYSE",
    stocks: [
      { 
        symbol: "XFX", 
        closes: [
          { date: new Date(2014,11,24), price: 240.10 },
          { date: new Date(2014,11,23), price: 232.08 },
          { date: new Date(2014,11,22), price: 241.09 }
        ]
      },
      { 
        symbol: "TNZ", 
        closes: [
          { date: new Date(2014,11,24), price: 521.24 },
          { date: new Date(2014,11,23), price: 511.00 },
          { date: new Date(2014,11,22), price: 519.29 }     
        ]
      },
    ]
  },
  { 
    name: "TSX",
    stocks: [
      { 
        symbol: "JXJ", 
        closes: [
          { date: new Date(2014,11,24), price: 423.22 },
          { date: new Date(2014,11,23), price: 424.84 },
          { date: new Date(2014,11,22), price: 419.72 }
        ]
      },
      { 
        symbol: "NYN", 
        closes: [
          { date: new Date(2014,11,24), price: 16.82 },
          { date: new Date(2014,11,23), price: 16.12 },
          { date: new Date(2014,11,22), price: 15.77 }
        ]
      },
    ]
  }
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
//[1,2,3].map(function(num) { return num + 1; }) -> [2,3,4]
//[1,2].map(function(num) { return [num + 1, num + 2]; }) -> [[2,3],[3,4]]

var christmasEveCloses =
  exchanges.
    map(function(exchange) {
      return exchange.stocks.
        map(function(stock) {
          return stock.closes.
            filter(function(close) {
              return close.date.getMonth() === 12 &&
                close.date.getDate() === 24;
            }).
            map(function(close) {
              return {
                symbol: stock.symbol,
                price: close.price
              };            
            });
        }).
        concatAll();
    }).
    concatAll();

christmasEveCloses.forEach(function(christmasEveClose) {
  console.log(christmasEveClose);
});