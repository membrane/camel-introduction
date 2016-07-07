var _ = require('underscore');

var einheit = {
  "Packung": "Pkg.",
  "Stück": "Stk.",
  "Flaschen": "Fl."
};

var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

// Nur die Positionen, bei denen 'lieferbar' == true ist
var lieferbar = _.filter(b.positionen, function(p) {
  return p.lieferbar;
});

request.body = JSON.stringify({
  "foo": "bar"
})