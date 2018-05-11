$(document).ready(function() {

	$(".addToCart").click(function(event) {

		// stop submit the form, we will post it manually.
		event.preventDefault();

		fire_ajax_submit(this.href);

	});

	$(".delete").click(function() {
		deleteItem(this.value);
	});

	$(".refresh").click(function() {
		console.log(" refresh ");
		console.log($("#" + this.value).val());
		refresh(this.value, $("#" + this.value).val());
		
		
	});

});

function fire_ajax_submit(url) {

	console.log(url);

	$.ajax({
		type : "GET",
		url : url,
		success : function(data) {
			console.log("SUCCESS : ", data);
			$("#checkout_items").html(data);

		},
		error : function(e) {

			console.log("ERROR : ", e);
		}
	});

}

function refresh(id, value) {

	$
			.ajax({
				type : "GET",
				url : "refreshBasket?productId=" + id + "&value=" + value,
				success : function(response) {
					location.reload();
					$("#checkout_items").html(response.length);

					$("#cart-table-body").remove();

					$("thead").after("<tbody id=\"cart-table-body\" \>");

					for (i = 0; i < response.length; i++) {
						$("#cart-table-body")
								.append(
										" <tr> <td data-th=\"Product\"> <div class=\"row\"> <div class=\"col-sm-2 hidden-xs\"> <img src="
												+ response[i].cartElement.product.img1
												+ "   alt=\"...\" class=\"img-responsive\" /> </div> <div class=\"col-sm-10\"> <h4 class=\"nomargin\"> "
												+ response[i].cartElement.product.name
												+ "  </h4> <p> "
												+ response[i].cartElement.product.description
												+ "  </p> </div> </div> </td> <td data-th=\"Price\">"
												+ response[i].cartElement.product.price
												+ " </td> <td data-th=\"Quantity\"><input type=\"number\" min=\"1\" id="
												+ response[i].cartElement.product.id
												+ " class=\"form-control text-center\" value="
												+ response[i].cartElement.quantity
												+ "></td> <td data-th=\"Subtotal\" class=\"text-center\">"
												+ response[i].price
												+ " </td> <td class=\"actions\" data-th=\"\"> <button class=\"btn btn-info btn-sm refresh\" value="
												// + refresh(
												+ response[i].cartElement.product.id
												// document
												// .getElementById(response[i].cartElement.product.id).value)
												+  "> <i class=\"fa fa-refresh\"></i> </button> <button class=\"btn btn-danger btn-sm delete\" value="
												+ response[i].cartElement.product.id
												+ " "
												// +
												// deleteItem(response[i].cartElement.product.id)
												+ "> <i class=\"fa fa-trash-o\"></i> </button> </td> </tr>  ");
					}

					$("<tfoot>").before("</tbody>");

					$(".refresh").click(function() {
						console.log(" refresh ");
						console.log(document.getElementById(this.value).value );
						refresh(this.value, document.getElementById(this.value).value );
					});

					$(".delete").click(function() {
						deleteItem(this.value);
					});

				}, 
				error : function(e) {

					console.log("ERROR : ", e);
				}
				
				
			});

	console.log(id + " " + value);
}

function deleteItem(id) {

	$
			.ajax({
				dataType : "json",
				type : "GET",
				url : "deleteItem?productId=" + id,
				success : function(response) {
					console.log(response);
					location.reload();
					$("#checkout_items").html(response.length);

					$("#cart-table-body").remove();

					$("thead").after("<tbody id=\"cart-table-body\" \>");
					
					$("#cart-table-body").loadTemplate($("#template"),response,{error: function(e) { console.log(e); }});

				/*	for (i = 0; i < response.length; i++) {
						$("#cart-table-body")
								.append(
										" <tr> <td data-th=\"Product\"> <div class=\"row\"> <div class=\"col-sm-2 hidden-xs\"> <img src="
												+ response[i].cartElement.product.img1
												+ "   alt=\"...\" class=\"img-responsive\" /> </div> <div class=\"col-sm-10\"> <h4 class=\"nomargin\"> "
												+ response[i].cartElement.product.name
												+ "  </h4> <p> "
												+ response[i].cartElement.product.description
												+ "  </p> </div> </div> </td> <td data-th=\"Price\">"
												+ response[i].cartElement.product.price
												+ " </td> <td data-th=\"Quantity\"><input type=\"number\" min=\"1\" id="
												+ response[i].cartElement.product.id
												+ " class=\"form-control text-center\" value="
												+ response[i].cartElement.quantity
												+ "></td> <td data-th=\"Subtotal\" class=\"text-center\">"
												+ response[i].price
												+ " </td> <td class=\"actions\" data-th=\"\"> <button class=\"btn btn-info btn-sm refresh\" value="
												// + refresh(
												+ response[i].cartElement.product.id
												// document
												// .getElementById(response[i].cartElement.product.id).value)
												+ "> <i class=\"fa fa-refresh\"></i> </button> <button class=\"btn btn-danger btn-sm delete\" value="
												+ response[i].cartElement.product.id
												+ " "
												// +
												// deleteItem(response[i].cartElement.product.id)
												+ "> <i class=\"fa fa-trash-o\"></i> </button> </td> </tr>  ");
					}*/

					$("<tfoot>").before("</tbody>");

					$(".refresh").click(function() {
						console.log(" refresh ");
						console.log($("#" + this.value).val());
						refresh(this.value, $("#" + this.value).val());
					});

					$(".delete").click(function() {
						deleteItem(this.value);
					});

				},
				error : function(e) {

					console.log("ERROR : ", e);
				}
			});
}

function latestThreeProduct(id) {

	$.ajax({
		type : "GET",
		url : "latestThreeProduct?productId=" + id,
		success : function(data) {
			console.log("SUCCESS : ", data);
			// $("#checkout_items").html(data);
			location.reload();
		},
		error : function(e) {

			console.log("ERROR : ", e);
		}
	});

	console.log(id)
}
