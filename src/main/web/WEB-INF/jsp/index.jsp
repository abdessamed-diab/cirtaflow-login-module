<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/defaultIndex.css" />
</head>
<body onresize="clearAllDivs('table-container'); createMultipleDivs('table-container'); drawBorder('#table-container')"
      onload="clearAllDivs('table-container'); createMultipleDivs('table-container'); drawBorder('#table-container')"
      style="background-color: hsla(0, 0%, 20%, 1);">

<div>
    <div class="ui-toolbar-container">

    </div>

    <div id="main-border">
        <table id="table-container">
            <caption>TABLE HEADING</caption>
        </table>
    </div>
</div>


<script type="text/javascript">
    var nbrCells= 25;

    function createMultipleDivs (tableElementID) {
        var tdSize= {x: getCSSValue('td', 'max-width'), y: getCSSValue('td', 'max-height') };
        tdSize.x=  Number(tdSize.x.substring(0, 3)) ;
        tdSize.y=  Number(tdSize.y.substring(0, 3)) ;

        var  co=0;

        var tableElement= document.getElementById(tableElementID);
        while (co < nbrCells){
            var trElement= document.createElement('tr');

            for(var i= 1; i<= getParentSize(tableElementID).x   / tdSize.x   ; i++ ) {
                var tdElement= document.createElement('td');
                var divElement= document.createElement('div');
                divElement.setAttribute('class', 'ui-square ui-square-transform');
                divElement.setAttribute('id', 'div-'+co);

                var centeredContainer= document.createElement('div');
                centeredContainer.setAttribute('id', 'centered-container');

                var firstButton= document.createElement('button');
                var secondButton= document.createElement('button');
                var linkElement= document.createElement('a');
                var bottomContainer= document.createElement('div');

                firstButton.setAttribute('class', "ui-button");
                firstButton.setAttribute('type', 'reset');
                firstButton.textContent= 'open'.toUpperCase();

                secondButton.setAttribute('class', 'ui-button');
                secondButton.setAttribute('type', 'reset');
                secondButton.textContent= "detail".toUpperCase();
                secondButton.addEventListener('dbClick', timer);

                linkElement.setAttribute('id', 'bottom-link');
                linkElement.setAttribute('href', 'http://www.google.com');
                linkElement.textContent= "CIRTA FLOW";

                bottomContainer.setAttribute('id', 'bottom-container');

                centeredContainer.appendChild(firstButton);
                centeredContainer.appendChild(secondButton);

                bottomContainer.appendChild(linkElement);

                divElement.appendChild(centeredContainer);
                divElement.appendChild(bottomContainer);

                tdElement.setAttribute('class', 'defaultColumn');

                tdElement.appendChild(divElement);
                trElement.appendChild(tdElement);
                co++;
                if(co>=nbrCells)
                    break;
            }
            tableElement.appendChild(trElement);
        }
    };

    function clearAllDivs(tableElementID) {
        var tableElement= document.getElementById(tableElementID);
        while(tableElement.firstChild)
            tableElement.removeChild(tableElement.firstChild);
    }

    function getSize(arg) {
        if(arg == 1) return document.documentElement.clientWidth;
        if(arg == 2) return document.documentElement.clientHeight;
        if(arg == 3) return window.innerWidth;
        if(arg == 4) return window.innerHeight;
    };

    function getParentSize(elementId){
        var element= document.getElementById(elementId);
        var parent= element.parentNode;
        var size= {x: parent.clientWidth,y: parent.clientHeight};
        return size;
    }

    function getCSSValue(cssClassName, attributeName){
        var stylesheetfile= null;
        for(var i=0; i<document.styleSheets.length; i++){
            if(document.styleSheets[i].href.includes('defaultIndex') ){
                stylesheetfile= document.styleSheets[i];
                break;
            }
        }

        for(var  i=0; i<stylesheetfile.cssRules.length; i++){
            if(stylesheetfile.cssRules[i].selectorText.includes(cssClassName) )
                return stylesheetfile.cssRules[i].style.getPropertyValue(attributeName);
        }
    };

    function drawBorder(tableId){
        var tableElement= document.querySelector(tableId);
        var nbrRows= tableElement.getElementsByTagName('tr').length;

        var tdHeight= getCSSValue('td', 'max-height').substring(0, 3);
        tdHeight= Number(tdHeight);

        document.body.firstElementChild.style.setProperty('height', (nbrRows*tdHeight)+8+'px', 'important');
    }

    var counter= 1;
    var intervalId= null;
    function timer() {
        intervalId= setInterval(deleteLastTd, 50);
    }

    function deleteLastTd() {
        counter++;
        var tableElement= document.querySelector('#table-container');
        if(tableElement.lastElementChild && tableElement.lastElementChild.lastElementChild ){
            tableElement.lastElementChild.deleteCell(tableElement.rowIndex);
        }

        if(tableElement.lastElementChild && !tableElement.lastElementChild.lastElementChild){
            tableElement.deleteRow(tableElement.lastElementChild.rowIndex);
        }

        if(counter > nbrCells-1) {
            clearInterval(intervalId);
            counter= 1;
            maximezSize();
        }

    }

    function maximezSize() {
        var lastSquare= document.querySelector('.ui-square');
        lastSquare.style.setProperty('width', '75%', 'important');
        lastSquare.style.setProperty('height', '768px', 'important');
    }

</script>


<!--<script type="text/babel">
    ReactDOM.render(
        <h2>square</h2>,
        document.getElementById('square')
    );
</script>-->

</body>
</html>
