### API-USAGE

```shell
curl -X POST --location "https://tradyl.anugrahsinghal.repl.co/api/v2/shipment/options" -H "Content-Type: application/json"  -d "{\"productCode\": \"123\",\"totalWeight\": \"2\",\"country\": \"USA\"}"
```

1. Currently only 2 Countries `USA/UK` supported
---

### Link to the sheet

[Go to Sheet](https://docs.google.com/spreadsheets/d/1LqvZjRIiVPRnLlSy0Sks2A-msFB1k96NtAT3b-aAFdA/edit?usp=sharing)

---

### APP-SCRIPT

```js
function tradyl_price(code, weight, country) {
	var data = {
		productCode: code,
		totalWeight: weight,
		country: country
	}

	var payload = JSON.stringify(data);

	var url = 'https://tradyl.anugrahsinghal.repl.co/api/v2/shipment/options';
	var options = {
		'method': 'post',
		'payload': payload,
		'cotentType': 'application/json',
	};

	var response = UrlFetchApp.fetch(url, options)
	Logger.log(response);

	var res = JSON.parse(response);

	let costs = [];

	for (var opt in res) {
		Logger.log(opt);
		costs.push(res[opt].shipmentCost);
	}

	Logger.log(costs);

	return [costs];
}
```
` =tradyl_price(c1,c2,c3)`

---


