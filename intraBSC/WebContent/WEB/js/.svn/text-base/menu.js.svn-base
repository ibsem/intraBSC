


/* Início do Código do Menu.
*/ 
var isDOM = (document.getElementById ? true : false); 
var isIE4 = ((document.all && !isDOM) ? true : false);
var isNS4 = (document.layers ? true : false);
function getRef(id) {
if (isDOM) return document.getElementById(id);
if (isIE4) return document.all[id];
if (isNS4) return document.layers[id];
}
function getSty(id) {
return (isNS4 ? getRef(id) : getRef(id).style);
} 
var popTimer = 0;
var litNow = new Array();
function popOver(menuNum, itemNum) {
menuOver();
clearTimeout(popTimer);
hideAllBut(menuNum);
litNow = getTree(menuNum, itemNum);
changeCol(litNow, true);
targetNum = menu[menuNum][itemNum].target;
if (targetNum > 0) {
thisX = parseInt(menu[menuNum][0].ref.left) + parseInt(menu[menuNum][itemNum].ref.left);
thisY = parseInt(menu[menuNum][0].ref.top) + parseInt(menu[menuNum][itemNum].ref.top);
with (menu[targetNum][0].ref) {
left = parseInt(thisX + menu[targetNum][0].x);
top = parseInt(thisY + menu[targetNum][0].y);
visibility = 'visible';
      }
   }
}
function popOut(menuNum, itemNum) {
menuOut();
if ((menuNum == 0) && !menu[menuNum][itemNum].target)
hideAllBut(0)
else
popTimer = setTimeout('hideAllBut(0)', 500);
}
function getTree(menuNum, itemNum) {
itemArray = new Array(menu.length);
while(1) {
itemArray[menuNum] = itemNum;
if (menuNum == 0) return itemArray;
itemNum = menu[menuNum][0].parentItem;
menuNum = menu[menuNum][0].parentMenu;
   }
}
function changeCol(changeArray, isOver) {
for (menuCount = 0; menuCount < changeArray.length; menuCount++) {
if (changeArray[menuCount]) {
newCol = isOver ? menu[menuCount][0].overCol : menu[menuCount][0].backCol;
with (menu[menuCount][changeArray[menuCount]].ref) {
if (isNS4) bgColor = newCol;
else backgroundColor = newCol;
         }
      }
   }
}
function hideAllBut(menuNum) {
var keepMenus = getTree(menuNum, 1);
for (count = 0; count < menu.length; count++)
if (!keepMenus[count])
menu[count][0].ref.visibility = 'hidden';
changeCol(litNow, false);
}
function Menu(isVert, popInd, x, y, width, overCol, backCol, borderClass, textClass) {
this.isVert = isVert;
this.popInd = popInd
this.x = x;
this.y = y;
this.width = width;
this.overCol = overCol;
this.backCol = backCol;
this.borderClass = borderClass;
this.textClass = textClass;
this.parentMenu = null;
this.parentItem = null;
this.ref = null;
}
/* Esta função define os parâmetros recebidos pelos itens do menu.
*/
function Item(text, href, frame, length, spacing, target, alinhamento, img, itemX, itemY) {
this.text = text;
this.href = href;
this.frame = frame;
this.length = length;
this.spacing = spacing;
this.target = target;
this.ref = null;
this.alinhamento = alinhamento;
this.img = img;
this.itemX = itemX;
this.itemY = itemY;
}
function writeMenus() {
if (!isDOM && !isIE4 && !isNS4) return;
for (currMenu = 0; currMenu < menu.length; currMenu++) with (menu[currMenu][0]) {
/* Posicionamento do menu é setado nos itens abaixo:
   itemX e itemY
   Obs: Defina primeiramente o local em que se posicionará seu menu
   para depois arrumar o posicionamento dos subitens.
*/
var str = '', itemX = 0, itemY = 0;
for (currItem = 1; currItem < menu[currMenu].length; currItem++) with (menu[currMenu][currItem]) {
var itemID = 'menu' + currMenu + 'item' + currItem;
var w = (isVert ? width : length);
var h = (isVert ? length : width);
if (isDOM || isIE4) {
str += '<div id="' + itemID + '" style="position: absolute; left: ' + itemX + '; top: ' + itemY + '; width: ' + w + '; height: ' + h + '; visibility: inherit;z-index:5; ';
if (backCol) str += 'background: ' + backCol + '; ';
str += '" ';
}
if (isNS4) {
str += '<layer id="' + itemID + '" left="' + itemX + '" top="' + itemY + '" width="' +  w + '" height="' + h + '" visibility="inherit" z-index="5" ';
if (backCol) str += 'bgcolor="' + backCol + '" ';
}
if (borderClass) str += 'class="' + borderClass + '" ';
str += 'onMouseOver="popOver(' + currMenu + ',' + currItem + ')" onMouseOut="popOut(' + currMenu + ',' + currItem + ')">';
str += '<table width="' + (w - 8) + '" border="0" cellspacing="0" cellpadding="' + (!isNS4 && borderClass ? 3 : 0) + '"><tr><td align="'+alinhamento+'" height="' + (h - 7) + '">' + '<a class="' + textClass + '" href="' + href + '"' + (frame ? ' target="' + frame + '">' : '>') + img + text + '</a></td>';
if (target > 0) {
menu[target][0].parentMenu = currMenu;
menu[target][0].parentItem = currItem;
if (popInd) str += '<td class="' + textClass + '" align="right">' + popInd + '</td>';
}
str += '</tr></table>' + (isNS4 ? '</layer>' : '</div>');
if (isVert) itemY += length + spacing;
else itemX += length + spacing;
}
if (isDOM) {
var newDiv = document.createElement('div');
document.getElementsByTagName('body').item(0).appendChild(newDiv);
newDiv.innerHTML = str;
ref = newDiv.style;
ref.position = 'absolute';
ref.visibility = 'hidden';
}
/* Testando e incluindo funções para Internet Explorer 4.0
*/
if (isIE4) {
document.body.insertAdjacentHTML('beforeEnd', '<div id="menu' + currMenu + 'div" ' + 'style="position: absolute; visibility: hidden">' + str + '</div>');
ref = getSty('menu' + currMenu + 'div');
}
/* Testando e incluindo funções para o Nestcape 4.6.
*/
if (isNS4) {
ref = new Layer(0);
ref.document.write(str);
ref.document.close();
}
for (currItem = 1; currItem < menu[currMenu].length; currItem++) {
itemName = 'menu' + currMenu + 'item' + currItem;
if (isDOM || isIE4) menu[currMenu][currItem].ref = getSty(itemName);
if (isNS4) menu[currMenu][currItem].ref = ref.document[itemName];
   }
}
with(menu[0][0]) {
ref.left = x;
ref.top = y;
ref.visibility = 'visible';
   }
}

/* Aqui começa a área de setagem do menu.
   Esta área é customizável, onde se define o layout do menu.
*/
var menu = new Array();
/* Declaração de duas variáveis que representam cores para serem usadas na setagem do menu.
   Sendo elas opcionais, podendo ser utilizado diretamente cores em padrões hexadecimal 
   na própria setagem do menu.
*/
var defOver = '#809CD4', defBack = '#E3E3E3';

/* Variável que representa a altura do subnível do menu
*/
var defLength = 20;
/* posicionamento do menu 
*/

/* Exemplo de valores do código abaixo: 
 X  =  indica a distância horizontal dos submenus em relação ao primeiro nível de menu.
 Y  =  indica a distância vertical dos submenus em relação ao primeiro nível de menu.
 Z  =  indica a largura dos subniveis do menu.
 defOver  =  indica a cor do rollover.
 defBack  =  indica a cor do menu.
Esta linha abaixo é utilizada para setagem de cor tamanho do novo bloco de menu a ser inserido.
true  =  se o menu é vertical ou horizontal.
'>'  =  quando houver um subnível, ele será indicado pelo sinal de maior.
menu[1][0] = new Menu(true, '>', X, Y, Z, defOver, defBack, 'menuBorda', 'menu');
#  =  url do link
'_new'  =  indica abertura em nova janela, caso a opção seja a não abertura deixar em branco. Ex: ''.
defLength  =  indica a altura dos itens do menu. 
menu[1][1] = new Item('Nome do item de menu 1', '#', '_new', defLength, 0, 0);
menu[1][2] = new Item('Nome do item de menu 2', '#', '', defLength, 0, 0);
O número 4(quatro) referenciado no final da linha abaixo representa um submenu. 
Neste caso referenciando o menu[4]
menu[1][3] = new Item('Nome do item de menu 3', '#', '', defLength, 0, 4);
*/
/* Lista de palavras que compõe o primeiro nível do menu 
*/
/* Funções indispensáveis para o funcionamento no Netscape 4.6
*/ 
var popOldWidth = window.innerWidth;
nsResizeHandler = new Function('if (popOldWidth != window.innerWidth) location.reload()');
if (isNS4) document.captureEvents(Event.CLICK);
document.onclick = clickHandle;
function clickHandle(evt)
{
 if (isNS4) document.routeEvent(evt);
 hideAllBut(0);
}
function moveRoot()
{
 with(menu[0][0].ref) left = ((parseInt(left) < 100) ? 100 : 5);
}


//--------------------------------------------------------------------\\

// array com o nome dos campos que devem ser escondidos ao mostrar o menu.
var esconder = new Array(3);
esconder[0] = "text";
esconder[1] = "password";
esconder[2] = "select-one";

function isEsconder(elemento){
	for (var x = 0; x < esconder.length; x++) {
		if(elemento.type == esconder[x]){
			return true;
		}
	} 
	return false;
}
function setFormVisibility(visible){
	var forms = document.forms;
	var elemento;
	for (var i = 0; i < forms.length; i++) {
		for (var j = 0; j < forms[i].elements.length; j++) {
			elemento = forms[i].elements[j];
			if(isEsconder(elemento)){
				visibilidade(elemento,visible);
			}
		}	
	}
}
function visibilidade(elemento,visible){
	var visibility = visible ? "" : "hidden";
	if(isNS4){
		visibility = visible ? "show" : "hide";
		elemento.visibility = visibility;
	} else {
		elemento.style.visibility = visibility;
	}
}
function menuOver(){
	setFormVisibility(false);
}
function menuOut(){
	setFormVisibility(true);
}