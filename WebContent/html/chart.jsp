<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %><%--
  Created by IntelliJ IDEA.
  User: centurio
  Date: 2019-05-13
  Time: 02:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src="../js/jquery.min.js"></script>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>

    <title>统计</title>
</head>
<body>
<%
    String data = new String((request.getParameter("data")).getBytes("ISO-8859-1"),"UTF-8");
%>


<div class="col-xs-2">
</div>

<div class="col-xs-9">
    <h1>
        代码分析统计图表
    </h1>
    <br/>
    <hr/>
    <br/>

    <div id="main1" style="width: 1000px;height:700px;"></div>
    <hr/>
    <div id="main2" style="width: 1000px;height:700px;"></div>
    <hr/>
    <div id="main3" style="width: 1000px;height:700px;"></div>
    <hr/>
</div>
</body>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    function sum(arr) {
        var sum = 0;
        for (var i = 0; i <arr.length ; i++) {
            sum+= parseInt(arr[i]);
        }
        return sum;
    }
    var myChart1 = echarts.init(document.getElementById('main1'));
    var data = <%out.print(data);%>;
    data = null;
    if (data == null) {
        data = [{
            "studentID": "151250001",
            "name": "李雷",
            "score": null,
            "bugs": "3",
            "vulnerabilities": "6",
            "codeSmells": "12",
            "coverage": "0.0",
            "duplicated_lines_density": "2.0",
            "sonarPath": "http://140.143.157.215:9000/dashboard?id=operating_system_1_151250001"
        }, {
            "studentID": "151250002",
            "name": "韩梅梅",
            "score": null,
            "bugs": "2",
            "vulnerabilities": "4",
            "codeSmells": "20",
            "coverage": "6.0",
            "duplicated_lines_density": "8.0",
            "sonarPath": "http://140.143.157.215:9000/dashboard?id=operating_system_1_151250002"
        }];

    }
    var name_list = [];
    var score_list = [];
    var bugs_list = [];
    var vulnerabilities_list = [];
    var codesmell_list = [];
    var coverage_list = [];
    var duplicated_lines_density_list = [];
    var list = data;

    for (var i = 0; i < data.length; i++) {


    	var score = (list[i].bugs * 5 + list[i].codeSmells * 0.5 + list[i].duplicated_lines_density * 1 + 0.3 * list[i].vulnerabilities)* 100 / list[i].coverage;
        score = Math.sqrt(score) * 10;
        score = Math.floor(100 - score);
        if (score < 0)
            score = 0;
        list[i].score = score;

        name_list.push(list[i].name);
        score_list.push(score);
        bugs_list.push(list[i].bugs);
        vulnerabilities_list.push(list[i].vulnerabilities);
        codesmell_list.push(list[i].codeSmells);
        coverage_list.push(list[i].coverage);
        duplicated_lines_density_list.push(list[i].duplicated_lines_density);


    }

    // 指定图表的配置项和数据
    var option1 = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data: name_list
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                // data : ['分数', 'bug', '漏洞', '代码异味', '覆盖率', '重复率'],
                data: name_list
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '分数',
                type: 'bar',
                data: score_list,
            },
            {
                name: 'bug',
                type: 'bar',
                data: bugs_list,
            },
            {
                name: '漏洞',
                type: 'bar',
                data: vulnerabilities_list,
            },
            {
                name: '代码异味',
                type: 'bar',
                data: codesmell_list,
            },
            {
                name: '覆盖率',
                type: 'bar',
                data: coverage_list,
            },
            {
                name: '重复率',
                type: 'bar',
                data: duplicated_lines_density_list,
            },
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart1.setOption(option1);

    // 基于准备好的dom，初始化echarts实例
    var myChart2 = echarts.init(document.getElementById('main2'));

    // 指定图表的配置项和数据
    var option2 = {
        backgroundColor: '#2c343c',

        title: {
            text: '问题类型统计',
            left: 'center',
            top: 20,
            textStyle: {
                color: '#ccc'
            }
        },

        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },

        visualMap: {
            show: false,
            min: 1,
            max: 100,
            inRange: {
                colorLightness: [0.5, 1]
            }
        },
        series: [
            {
                name: '问题类型',
                type: 'pie',
                radius: '55%',
                center: ['50%', '50%'],
                data: [
                    {value: sum(bugs_list), name: 'bug'},
                    {value: sum(vulnerabilities_list), name: '漏洞'},
                    {value: sum(codesmell_list), name: '异味'},
                    {value: sum(duplicated_lines_density_list), name: '重复'},
                    {value: sum(coverage_list), name: '覆盖'}
                ].sort(function (a, b) {
                    return a.value - b.value;
                }),
                roseType: 'radius',
                minAngle:80,
                label: {
                    normal: {
                        textStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        lineStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        },
                        smooth: 0.2,
                        length: 10,
                        length2: 20
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#c23531',
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },

                animationType: 'scale',
                animationEasing: 'elasticOut',
                animationDelay: function (idx) {
                    return Math.random() * 200;
                }
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart2.setOption(option2);


</script>
</html>
