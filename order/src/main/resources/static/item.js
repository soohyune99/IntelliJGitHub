/*
* item/list.html
* */
const $checkboxes = $("input[type='checkbox']");
const $table = $("#cart");
let check = 0;

$checkboxes.on("click", function(){
    let index = $checkboxes.index($(this));
    let $tds = $(this).closest("tr").children();
    let text = "";
    if($(this).is(":checked")){
        text += `<tr id="` + index + `">`;
        text += `<td><input name="orders[` + check + `].itemNumber" value="` + $tds.eq(1).text() + `" readonly></td>`;
        text += `<td><input name="orders[` + check + `].itemName" value="` + $tds.eq(2).text() + `" readonly></td>`;
        text += `<td><input name="orders[` + check + `].itemCount"></td>`;
        text += `</tr>`;
        $table.append(text);
        check ++;
    }else{
        $table.find("tr").remove("#" + index);
        check --;
    }
});