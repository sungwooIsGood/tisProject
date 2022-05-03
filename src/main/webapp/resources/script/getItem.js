$(function() {
	$(document).on("click", ".updateItem", function() {
		let itemNo = $(this).parent().attr("data-itemNo");
		let itemName = $(this).parent().attr("data-itemName");
		let item = $(this);
		
		createInput(item, itemNo, itemName);
	});
	
	$(document).on("click", ".inputCancel", function() {
		let itemNo = $(this).parent().attr("data-itemNo");
		let itemName = $(this).parent().attr("data-itemName");
		let item = $(this);
		
		deleteInput(item, itemNo, itemName);
	});
	
    $(document).on("click", ".updateItemSubmit", function() {
		let itemNo = $(this).parent().attr("data-itemNo");
		let itemName = $(this).siblings(".itemInput").val();
		let item = $(this);
		
		let param = {"itemNo":itemNo, "itemName":itemName};
		
		$.ajax({
			type: "POST",
			data: JSON.stringify(param),
            url: `updateItem.do`,
            contentType:"application/json; charset=utf-8",
            success: function(data) {
                item.parent().attr("data-itemName", itemName);
                
                deleteInput(item, itemNo, itemName);
            },
            error: function() {
                alert("통신 에러");
            }
		});
    });
    
    $(document).on("click", ".deleteItem", function() {
		let itemNo = $(this).parent().attr("data-itemNo");
		let item = $(this);
		
		let param = {"itemNo":itemNo};
		
		$.ajax({
			type: "POST",
			data: JSON.stringify(param),
            url: `deleteItem.do`,
            contentType:"application/json; charset=utf-8",
            success: function(data) {
                item.parent().remove();
            },
            error: function() {
                alert("통신 에러");
            }
		});
    });
    

	$(document).on("click", ".insertItem", function() {
		let itemOption = $(".insertItemOption").val();
		let itemName = $(".insertItemName").val();
		
		let param = {"itemOption":itemOption,"itemName":itemName};
		
		if (itemName == "") {
			alert("항목 내용을 입력해 주세요");
			$(".insertItemName").focus();
			return false;
		}
		
		$.ajax({
			type: "POST",
			data: JSON.stringify(param),
            url: `insertItem.do`,
            contentType:"application/json; charset=utf-8",
            dataType:"json",
            success: function(data) {
                itemNo = data.itemNo;
                
                insertItem = "<div class='item clear' data-itemNo='" 
                	+ itemNo + "' data-itemName='" + itemName + "'>";
                insertItem += "<div class='itemName'>";
                insertItem += itemName;
                insertItem += "</div>";
                insertItem += "<button class='updateItem'>수정</button> ";
                insertItem += "<button class='deleteItem'>삭제</button>";
                insertItem += "</div>";
                
                if (itemOption == 'G') {
                	$(".genre").append(insertItem);
                } else if (itemOption == 'N') {
                	$(".nation").append(insertItem);
                } else if (itemOption == 'P') {
                	$(".point").append(insertItem);
                }
                
                alert("항목이 추가되었습니다");
                $(".insertItemName").val("");
                	
            },
            error: function() {
                alert("통신 에러");
            }
		});
	});
    
    function createInput (item, itemNo, itemName) {
    	item.parent().prepend("<button class='inputCancel'>취소</button>");
    	item.parent().prepend("<button class='updateItemSubmit'>완료</button>")
		item.parent().prepend("<input type='text' class='itemInput' value='"+ itemName + "'>");
    	item.siblings(".itemName").remove();
    	item.siblings(".deleteItem").remove();
    	item.siblings(".updateItem").remove();
    	item.remove();
    }
    
    function deleteInput (item, itemNo, itemName) {
    	item.parent().prepend("<button class='deleteItem'>삭제</button>");
    	item.parent().prepend("<button class='updateItem'>수정</button> ");
    	item.parent().prepend("<div class='itemName'>"+ itemName +"</div>");
    	item.siblings(".itemInput").remove();
    	item.siblings(".updateItemSubmit").remove();
    	item.siblings(".inputCancel").remove();
    	item.remove();
    }
});

