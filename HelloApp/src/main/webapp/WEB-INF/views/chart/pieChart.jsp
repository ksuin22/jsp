<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>

<head>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
    google.charts.load('current', {
      'packages': ['corechart']
    });
    google.charts.setOnLoadCallback(drawChart);



    function drawChart() {
      console.log('1')
      var result = [
        ['dept', 'cnt']
      ];

      console.log('2')
      let xhtp = new XMLHttpRequest(); //비동기방식처리(=AJAX 호출).순차적X
      xhtp.open('get', 'chartData.do');
      xhtp.send(); //서버에 데이터요청

      xhtp.onload = function () {
        console.log(xhtp.response)
        let data = JSON.parse(xhtp.response); // {'admin':3, 'sales':5... 'shipping':3} 	  
        for (let dept in data) {
          console.log(dept, data[dept]); //부서명,부서인원
          result.push([dept, data[dept]]); //배열에 담기			  
        }
        console.log(result);

        console.log('4')
        data = google.visualization.arrayToDataTable(result);
        var options = {
          title: '부서별 인원 현황'
        };
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options); //차트를 보여주는 함수 draw
      }

    }
  </script>
</head>

<body>
  <div id="piechart" style="width: 900px; height: 500px;"></div>
</body>

</html>