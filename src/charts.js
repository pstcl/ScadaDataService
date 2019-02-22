let freqChartdata = null;
let freqChart = null;
let freqChartoptions = null;
let drawalChartdata = null;
let drawalChartoptions = null;
let drawalChart = null;
let gauge;
let gaugeData;
let gaugeOptions = {
		min : 48,
		max : 52,
		yellowFrom : 50.50,
		yellowTo : 52,
		redFrom : 48,
		redTo : 49.50,
		greenFrom : 49.50,
		greenTo : 50.50,
		yellowColor:'#DC3912',
		minorTicks : 5
	};


function drawCharts() {
	drawFrequencyChart();
	drawDrawalChart();
	drawGauge();
}
function makeFreqJsonDataRequest( noOfRecord, data, chart, options) {
	var url="http://localhost:9091/scadadata/frequency/";
	var xhr = new XMLHttpRequest();
	xhr.open('GET', url + noOfRecord, true, "user", "password");
	xhr.withCredentials = true;
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var jsonData = JSON.parse(xhr.responseText);
			data.removeRows(0,data.getNumberOfRows());
			for (var i = jsonData.length-1; i >=0 ; i--) {
				data.addRow([ jsonData[i].timeS, jsonData[i].value ]);
				gaugeData.removeRows(0);
				gaugeData.setCell(0, 0, jsonData[i].value);
				gauge.draw(gaugeData, gaugeOptions);

			}
			console.log("data-" + data.getNumberOfRows()
					+ (new Date()).toString());
			chart.draw(data, options);
		}
	}
}
function drawFrequencyChart() {

	freqChartdata = new google.visualization.DataTable();
	freqChartdata.addColumn('string', 'TimeS');
	freqChartdata.addColumn('number', 'Frequency(Hz)');
	freqChart = new google.visualization.LineChart(document
			.getElementById('freqChart_div'));
	freqChartoptions = {
		lineWidth : 4,
		'title' : 'Frequency Chart',
		hAxis : {
			title : 'Date Time'
		},
		vAxis : {

			title : 'Frequency(Hz)',
			viewWindow : {
				min : 48,
				max : 52
			},
			ticks : [ 48,48.5,49, 49.5, 50, 50.5, 51,51.5,52 ]
		},
		'width' : 300,
		'height' : 300
	};
	makeFreqJsonDataRequest( 10,
			freqChartdata, freqChart, freqChartoptions);
	console.log("Data:" + freqChartdata.getNumberOfRows()
			+ (new Date()).toString()); //
	freqChart.draw(freqChartdata, freqChartoptions);
	setInterval(updateFrequencyChartData, 10 * 1000);
}
function updateFrequencyChartData() {

	makeFreqJsonDataRequest( 15,
			freqChartdata, freqChart, freqChartoptions);
	freqChart.draw(freqChartdata, freqChartoptions);
}

function makeDrawalJsonDataRequest(url, noOfRecord, data, chart, options) {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', url + noOfRecord, true, "user", "password");
	xhr.withCredentials = true;
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var jsonData = JSON.parse(xhr.responseText);
			data.removeRows(0,data.getNumberOfRows());
			
			for (var i = jsonData.length-1; i >=0 ; i--) {
				data.addRow([ jsonData[i].timeS, jsonData[i].value ]);
				
			}
			console.log("data-" + data.getNumberOfRows()
					+ (new Date()).toString());
			chart.draw(data, options);
		}
	}
}
function drawDrawalChart() {
	drawalChartdata = new google.visualization.DataTable();
	drawalChartdata.addColumn('string', 'TimeS');
	drawalChartdata.addColumn('number', 'Drawal(MW)');
	drawalChart = new google.visualization.LineChart(document
			.getElementById('drawalChart_div'));
	drawalChartoptions = {
		lineWidth : 4,
		'title' : 'Drawal Chart',
		hAxis : {
			title : 'Date Time'
		},
		vAxis : {

			title : 'Drawal(MW)',
			viewWindow : {
				min : 500,
				max : 2000
			},
			ticks : [ 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400,
					1500, 1600, 1700, 1800, 1900, 2000 ]
		},
		'width' : 300,
		'height' : 300
	};
	drawalChart.draw(drawalChartdata, drawalChartoptions);

	makeDrawalJsonDataRequest("http://localhost:9091/scadadata/drawal/", 15,
			drawalChartdata, drawalChart, drawalChartoptions);
	drawalChart.draw(drawalChartdata, drawalChartoptions);
	setInterval(updateDrawalChartData, 10 * 1000);
}
function updateDrawalChartData() {

	makeDrawalJsonDataRequest("http://localhost:9091/scadadata/drawal/", 15,
			drawalChartdata, drawalChart, drawalChartoptions);
	drawalChart.draw(drawalChartdata, drawalChartoptions);
}


function drawGauge() {
	gaugeData = new google.visualization.DataTable();
	gaugeData.addColumn('number', 'Frequency');
	gaugeData.addRows(1);
	
	gauge = new google.visualization.Gauge(document.getElementById('gauge_div'));
	gauge.draw(gaugeData, gaugeOptions);
}
