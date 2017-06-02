<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: don
  Date: 5/28/17
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Game</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script>
        function submitGameResult(name, step) {
//            String modeId, String name, String step
            $.ajax({
                type: "POST",
                url: "/game/submitGameResult",
                data: {
                    modeId: ${mode.modeid},
                    name: name,
                    step: step,
                },
                success: function (data) {
                    alert('success');
                },
                error: function () {
                    alert('fail');
                }
            })
        }

    </script>
</head>
<body>

<div id="divGameScenes">
    <div><label>使用最少步數完成全屏同一顏色</label></div>
    <table id="tableGame">

    </table>
    <div>
        <label style="background-color: #00FFFF"><input id="radioColor1" type="radio" name="radioColor" checked="true"/>#00FFFF</label>
        <label style="background-color: #0000FF"><input id="radioColor2" type="radio" name="radioColor"/>#0000FF</label>
        <label style="background-color: #00FF00"><input id="radioColor3" type="radio" name="radioColor"/>#00FF00</label>
    </div>
    <label>當前步數：<label id="labStep" data-step="0">0</label></label>
    <P>
        <c:if test="${!empty recordList}">
    <table>
        <tr>
            <th>玩家</th>
            <th>步数</th>
        </tr>
        <c:forEach var="current" items="${recordList}">
            <tr>
                <td><c:out value="${current.recordname}"/></td>
                <td><c:out value="${current.step}"/></td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
    </P>
</div>

<script type="text/javascript">
    var madeInfo = ${mode.modeinfo};
    var gameModel = {
        xSize: "${mode.xsize}", ySize: "${mode.ysize}",
        color1: madeInfo.color1,
        color2: madeInfo.color2,
        color3: madeInfo.color3
    };
    //    var gameModel = {xSize: 20, ySize: 20, view: 'html'};
    //    var gameModel = {xSize: 20, ySize: 20, colorCell: [{color1: 'rgb(0, 255, 255)', cellList: [{i: 0, j: 0}]}]};
    var cellArray = new Array(gameModel.ySize);            //所有數組成員
    var colorRed = 'rgb(0, 255, 255)';      //默認顏色
    var colorYellow = 'rgb(0, 0, 255)';     //默認顏色
    var colorBlue = 'rgb(0, 255, 0)';       //默認顏色
    //    var xSize = 20;                         //最大x
    //    var ySize = 10;                         //最大y
    var cellSize = 40;                      //cell大小

    function initGame() {
        var tableGame = document.getElementById("tableGame");

        for (var j = 0; j < gameModel.ySize; j++) {
            cellArray[j] = [];
            for (var i = 0; i < gameModel.xSize; i++) {
                var cellInfo = new Object();
                cellInfo.i = i;
                cellInfo.j = j;
                cellArray[j][i] = cellInfo;
            }
        }

        for (var x = 0, size = gameModel.color1.length; x < size; x++) {
            console.log(gameModel.color1[x]);
            var xP = gameModel.color1[x].x;
            var yP = gameModel.color1[x].y;
            cellArray[yP][xP].color = colorRed;
        }
        console.log("--------");
        for (var x = 0, size = gameModel.color2.length; x < size; x++) {
            console.log(gameModel.color2[x]);
            var xP = gameModel.color2[x].x;
            var yP = gameModel.color2[x].y;
            cellArray[yP][xP].color = colorYellow;
        }
        console.log("--------");
        for (var x = 0, size = gameModel.color3.length; x < size; x++) {
            console.log(gameModel.color3[x]);
            var xP = gameModel.color3[x].x;
            var yP = gameModel.color3[x].y;
            cellArray[yP][xP].color = colorBlue;
        }
        console.log("--------");

        for (var j = 0; j < cellArray.length; j++) {
            var tr = document.createElement("tr");
            for (var i = 0; i < cellArray[j].length; i++) {
                var td = document.createElement("td");
                var color = cellArray[j][i].color;
                cellArray[j][i].obj = td;
                td.width = cellSize;
                td.height = cellSize;
                td.style.backgroundColor = color;
                td.setAttribute('data-i', '' + i);
                td.setAttribute('data-j', '' + j);
                td.setAttribute('data-color', '' + color);
                tr.appendChild(td);
            }
            tableGame.appendChild(tr);
        }
    }

    function onClickCell(cellObj) {
        var labStep = document.getElementById("labStep");
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

        labStep.innerHTML = parseInt(labStep.innerHTML) + 1;

        console.log('current ' + currentI + ',' + currentJ + ',' + currentColor);

        cellArray[currentJ][currentI].obj.style.backgroundColor = pickColor;
        cellArray[currentJ][currentI].obj.setAttribute('data-color', '' + pickColor);
        //left
        var i, j;
        if (currentI - 1 >= 0) {
            i = currentI - 1;
            j = currentJ;
            console.log('left ' + i + ',' + j + ',' + cellArray[j][i].obj.style.backgroundColor);
            if (currentColor == cellArray[j][i].obj.style.backgroundColor) {
                cellArray[j][i].obj.style.backgroundColor = pickColor;
                cellArray[j][i].obj.setAttribute('data-color', '' + pickColor);
                findSameColor(cellArray[j][i].obj, currentColor, pickColor);
            }
        }
        //right
        if (currentI + 1 < gameModel.xSize) {
            i = currentI + 1;
            j = currentJ;
            console.log('right ' + i + ',' + j);
            if (currentColor == cellArray[j][i].obj.style.backgroundColor) {
                cellArray[j][i].obj.style.backgroundColor = pickColor;
                cellArray[j][i].obj.setAttribute('data-color', '' + pickColor);
                findSameColor(cellArray[j][i].obj, currentColor, pickColor);
            }
        }
        //top
        if (currentJ - 1 >= 0) {
            i = currentI;
            j = currentJ - 1;
            console.log('top ' + i + ',' + j);
            if (currentColor == cellArray[j][i].obj.style.backgroundColor) {
                cellArray[j][i].obj.style.backgroundColor = pickColor;
                cellArray[j][i].obj.setAttribute('data-color', '' + pickColor);
                findSameColor(cellArray[j][i].obj, currentColor, pickColor);
            }
        }
        //bottom
        if (currentJ + 1 < gameModel.ySize) {
            i = currentI;
            j = currentJ + 1;
            console.log('bottom ' + i + ',' + j);
            if (currentColor == cellArray[j][i].obj.style.backgroundColor) {
                cellArray[j][i].obj.style.backgroundColor = pickColor;
                cellArray[j][i].obj.setAttribute('data-color', '' + pickColor);
                findSameColor(cellArray[j][i].obj, currentColor, pickColor);
            }
        }

        checkFinish();
    }

    function findSameColor(nextCellObj, color, pickColor) {
//        nextCellArray.push(nextCellObj);
        var currentI = parseInt(nextCellObj.getAttribute('data-i'));
        var currentJ = parseInt(nextCellObj.getAttribute('data-j'));
        var currentColor = color;
        console.log('findSameColor current ' + currentI + ',' + currentJ + ',' + currentColor);

        cellArray[currentJ][currentI].obj.style.backgroundColor = pickColor;
        cellArray[currentJ][currentI].obj.setAttribute('data-color', '' + pickColor);
        //left
        var i, j;
        if (currentI - 1 >= 0) {
            i = currentI - 1;
            j = currentJ;
            console.log('left ' + i + ',' + j + ',' + cellArray[j][i].obj.style.backgroundColor);
            if (currentColor == cellArray[j][i].obj.style.backgroundColor) {
                cellArray[j][i].obj.style.backgroundColor = pickColor;
                cellArray[j][i].obj.setAttribute('data-color', '' + pickColor);
                findSameColor(cellArray[j][i].obj, currentColor, pickColor);
            }
        }
        //right
        if (currentI + 1 < gameModel.xSize) {
            i = currentI + 1;
            j = currentJ;
            console.log('right ' + i + ',' + j);
            if (currentColor == cellArray[j][i].obj.style.backgroundColor) {
                cellArray[j][i].obj.style.backgroundColor = pickColor;
                cellArray[j][i].obj.setAttribute('data-color', '' + pickColor);
                findSameColor(cellArray[j][i].obj, currentColor, pickColor);
            }
        }
        //top
        if (currentJ - 1 >= 0) {
            i = currentI;
            j = currentJ - 1;
            console.log('top ' + i + ',' + j);
            if (currentColor == cellArray[j][i].obj.style.backgroundColor) {
                cellArray[j][i].obj.style.backgroundColor = pickColor;
                cellArray[j][i].obj.setAttribute('data-color', '' + pickColor);
                findSameColor(cellArray[j][i].obj, currentColor, pickColor);
            }
        }
        //bottom
        if (currentJ + 1 < gameModel.ySize) {
            i = currentI;
            j = currentJ + 1;
            console.log('bottom ' + i + ',' + j);
            if (currentColor == cellArray[j][i].obj.style.backgroundColor) {
                cellArray[j][i].obj.style.backgroundColor = pickColor;
                cellArray[j][i].obj.setAttribute('data-color', '' + pickColor);
                findSameColor(cellArray[j][i].obj, currentColor, pickColor);
            }
        }
    }

    function checkFinish() {
        var currentColor = cellArray[0][0].obj.style.backgroundColor
        var isFinish = true;
        for (var j = 0; j < gameModel.ySize; j++) {
            for (var i = 0; i < gameModel.xSize; i++) {
                if (cellArray[i][j].obj.style.backgroundColor != currentColor) {
                    isFinish = false;
                    break;
                }
            }
        }
        if (isFinish) {
            var labStep = document.getElementById("labStep");
            alert(labStep.innerHTML + '步完成')
            var theResponse = window.prompt("留下您的大名", "请在此输入您的昵称");
            if (null != theResponse) {
                submitGameResult(theResponse, labStep.innerHTML);
            }
        }
    }

    $(document).ready(function () {
        initGame();
        $('#tableGame tr td').map(function () {
            var td = $(this);
            td.on('click', function () {
                onClickCell(td);
            });
        })

    })

</script>
</body>
</html>
