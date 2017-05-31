<%--
  Created by IntelliJ IDEA.
  User: don
  Date: 5/29/17
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <style>
        td {
            border: solid;
            border-width: 1px;
        }
    </style>
</head>
<body>
<form action="/mode/create" method="post">

    <div id="divGameScenes" name="">
        <div>
            <p>x:<input type="text" id="inputX" name="inputX"></p>
            <p>y:<input type="text" id="inputY" name="inputY"></p>
            <p><input type="button" value="Set Size" onclick="onClickBtnSet()"></p>
        </div>
        <table id="tableGame">

        </table>
        <div>
            <label style="background-color: #00FFFF"><input id="radioColor1" type="radio" name="radioColor"
                                                            checked="true"/>#00FFFF</label>
            <label style="background-color: #0000FF"><input id="radioColor2" type="radio"
                                                            name="radioColor"/>#0000FF</label>
            <label style="background-color: #00FF00"><input id="radioColor3" type="radio"
                                                            name="radioColor"/>#00FF00</label>
        </div>

        <p><input type="text" id="modeName" name="modeName"></p>
        <p><input type="button" value="Create Mode" onclick="onClickSubmit()"></p>
    </div>

    <script type="text/javascript">
        //    var gameModel = {xSize: 20, ySize: 20, view: 'html'};
        //    var gameModel = {xSize: 20, ySize: 20, colorCell: [{color1: 'rgb(0, 255, 255)', cellList: [{i: 0, j: 0}]}]};
        var cellArray = new Array();            //所有數組成員
        var colorRed = 'rgb(0, 255, 255)';      //默認顏色
        var colorYellow = 'rgb(0, 0, 255)';     //默認顏色
        var colorBlue = 'rgb(0, 255, 0)';       //默認顏色
        //    var xSize = 20;                         //最大x
        //    var ySize = 10;                         //最大y
        var cellSize = 40;                      //cell大小

        function initGame(x, y) {
            var tableGame = document.getElementById("tableGame");
            var childNode = tableGame.childNodes;
            if (null != childNode) {
                for (var i = childNode.length - 1; i > 0; i--) {
                    tableGame.removeChild(childNode[i]);
                }
            }
            for (var j = 0; j < y; j++) {
                var tr = document.createElement("tr");
                cellArray[j] = [];
                for (var i = 0; i < x; i++) {
                    var td = document.createElement("td");
                    var cellInfo = new Object();

                    cellInfo.i = i;
                    cellInfo.j = j;
                    cellInfo.obj = td;
                    cellArray[j][i] = cellInfo;
//                console.log(cellArray[i, j].obj);
                    td.width = cellSize;
                    td.height = cellSize;
//                td.innerHTML = i + "," + j;
                    td.style.backgroundColor = colorRed;
                    td.setAttribute('data-i', '' + i);
                    td.setAttribute('data-j', '' + j);
                    td.setAttribute('data-color', '' + colorRed);

                    tr.appendChild(td);
                }
                tableGame.appendChild(tr);
            }

            $('#tableGame tr td').map(function () {
                var td = $(this);
                td.on('click', function () {
                    onClickCell(td);
                });
            })
        }

        function onClickCell(cellObj) {
//            var labStep = document.getElementById("labStep");
            var radio1 = document.getElementById("radioColor1");
            var radio2 = document.getElementById("radioColor2");
            var radio3 = document.getElementById("radioColor3");
            var pickColor;

            if (radio1.checked == true) {
                pickColor = colorRed;
            }
            if (radio2.checked == true) {
                pickColor = colorYellow;
            }
            if (radio3.checked == true) {
                pickColor = colorBlue;
            }

            var currentI = parseInt(cellObj.attr('data-i'));
            var currentJ = parseInt(cellObj.attr('data-j'));
            var currentColor = cellObj.attr('data-color');
            if (pickColor == currentColor) {
                return;
            }

//            labStep.innerHTML = parseInt(labStep.innerHTML) + 1;

            console.log('current ' + currentI + ',' + currentJ + ',' + currentColor);

            cellArray[currentJ][currentI].obj.style.backgroundColor = pickColor;
            cellArray[currentJ][currentI].obj.setAttribute('data-color', '' + pickColor);
        }

        function onClickBtnSet() {
            var x = document.getElementById('inputX').value;
            var y = document.getElementById('inputY').value;
            initGame(x, y);
        }

        //        $(document).ready(function () {
        //alert(123);
        //        initGame();
        // console.log(cellArray);
        //        $('#tableGame tr td').map(function () {
        //            var td = $(this);
        //            td.on('click', function () {
        //                onClickCell(td);
        //            });
        //        })

        //        })
        function onClickSubmit() {
            var name = document.getElementById('modeName').value;
            var x = document.getElementById('inputX').value;
            var y = document.getElementById('inputY').value;
            var color1List = new Array();
            var color2List = new Array();
            var color3List = new Array();

            $('#tableGame tr td').map(function () {
                var td = $(this);
                var currentI = parseInt(td.attr('data-i'));
                var currentJ = parseInt(td.attr('data-j'));
                var currentColor = td.attr('data-color');

                if (currentColor == colorRed) {
                    var color1Json = {x: currentI, y: currentJ};
                    color1List.push(color1Json);
                } else if (currentColor == colorYellow) {
                    var color2Json = {x: currentI, y: currentJ};
                    color2List.push(color2Json);
                } else if (currentColor == colorBlue) {
                    var color3Json = {x: currentI, y: currentJ};
                    color3List.push(color3Json);
                }
            })

            $.ajax({
                type: "POST",
                url: "/mode/create",
                data: {
                    modeName: name,
                    inputX: x, inputY: y,
                    color1: JSON.stringify(color1List),
                    color2: JSON.stringify(color2List),
                    color3: JSON.stringify(color3List)},
//                    color1: JSON.stringify(color1List),
//                    color2: JSON.stringify(color2List),
//                    color3: JSON.stringify(color3List)},
                success: function (data) {
                    alert('success');
                },
                error: function () {
                    alert('fail');
                }
            })
        }
    </script>
</form>
</body>
</html>
