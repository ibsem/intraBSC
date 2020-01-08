// full day names
Calendar._DN = new Array
("Domingo",
 "Segunda",
 "Terça",
 "Quarta",
 "Quinta",
 "Sexta",
 "Sabádo",
 "Domingo");

// Please note that the following array of short day names (and the same goes
// for short month names, _SMN) isn't absolutely necessary.  We give it here
// for exemplification on how one can customize the short day names, but if
// they are simply the first N letters of the full name you can simply say:
//
//   Calendar._SDN_len = N; // short day name length
//   Calendar._SMN_len = N; // short month name length
//
// If N = 3 then this is not needed either since we assume a value of 3 if not
// present, to be compatible with translation files that were written before
// this feature.

// short day names
// [No changes using default values]

// full month names
Calendar._MN = new Array
("Janeiro",
 "Fevereiro",
 "Março",
 "Abril",
 "Maio",
 "Junho",
 "Julho",
 "Agosto",
 "Setembro",
 "Outubro",
 "Novembro",
 "Dezembro");

// short month names
// [No changes using default values]

// tooltips
Calendar._TT_br = Calendar._TT = {};
Calendar._TT["INFO"] = "Sobre o calendário";

Calendar._TT["ABOUT"] =
"Selecionar data:\n" +
"- Use as teclas \xab, \xbb para selecionar o ano\n" +
"- Use as teclas " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " para selecionar o mês\n" +
"- Clique e segure com o mouse em qualquer botão para selecionar rapidamente.";

Calendar._TT["ABOUT_MES"] =
"Selecionar data:\n\n" +

"- Clique no dia desejado";

Calendar._TT["ABOUT_TIME"] = "\n\n" +
"Selecionar hora:\n" +
"- Clique em qualquer uma das partes da hora para aumentar\n" +
"- ou Shift-clique para diminuir\n" +
"- ou pressione para selecionar rapidamente.";

Calendar._TT["PREV_YEAR"] = "Ano anterior (clique e segure para menu)";
Calendar._TT["PREV_MONTH"] = "Mês anterior (clique e segure para menu)";
Calendar._TT["GO_TODAY"] = "Ir para a data atual";
Calendar._TT["NEXT_MONTH"] = "Próximo mês (clique e segure para menu)";
Calendar._TT["NEXT_YEAR"] = "Próximo ano (clique e segure para menu)";
Calendar._TT["SEL_DATE"] = "Selecione uma data";
Calendar._TT["SEL_TIME"] = "Selecione um horário";
Calendar._TT["DRAG_TO_MOVE"] = "Clique e segure para mover";
Calendar._TT["PART_TODAY"] = " (hoje)";

// the following is to inform that "%s" is to be the first day of week
// %s will be replaced with the day name.
Calendar._TT["DAY_FIRST"] = "Exibir %s primeiro";

// This may be locale-dependent.  It specifies the week-end days, as an array
// of comma-separated numbers.  The numbers are from 0 to 6: 0 means Sunday, 1
// means Monday, etc.
Calendar._TT["WEEKEND"] = "0,6";

Calendar._TT["CLOSE"] = "Fechar";
Calendar._TT["TODAY"] = "Hoje";
Calendar._TT["TIME_PART"] = "(Shift-)Clique ou pressione";

// date formats
Calendar._TT["DEF_DATE_FORMAT"] = "%d/%m/%Y";
Calendar._TT["TT_DATE_FORMAT"] = "%d de %B de %Y";

Calendar._TT["WK"] = "sem";
Calendar._TT["TIME"] = "Hora:";
Calendar._TT["NUMERO_PERMITIDO"] = "Número permitido de datas: "

Calendar._TT["INFORME_MES"] = "Informe o mês";
/* Preserve data */
	if(Calendar._DN) Calendar._TT._DN = Calendar._DN;
	if(Calendar._SDN) Calendar._TT._SDN = Calendar._SDN;
	if(Calendar._SDN_len) Calendar._TT._SDN_len = Calendar._SDN_len;
	if(Calendar._MN) Calendar._TT._MN = Calendar._MN;
	if(Calendar._SMN) Calendar._TT._SMN = Calendar._SMN;
	if(Calendar._SMN_len) Calendar._TT._SMN_len = Calendar._SMN_len;
	Calendar._DN = Calendar._SDN = Calendar._SDN_len = Calendar._MN = Calendar._SMN = Calendar._SMN_len = null
