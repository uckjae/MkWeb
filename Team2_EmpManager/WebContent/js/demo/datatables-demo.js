$(function() {
  let table = $('#dataTable').DataTable();
  
  $('#dataTable_filter').prepend('<select id="select" class="custom-select" style="margin-right : 10px; width: 80px"></select>');
  
  // 검색 th 칼럼 별로 할 수 있게 select 생성
  let ths = $('#dataTable > thead > tr > th');
  ths.each(function (index, element) { 
	  if(index < ths.length - 2) // EDIT, DELETE 칼럼 빼고
		  $('#select').append('<option>'+element.innerHTML+'</option>');
  });
  
  // select에 따라 검색 결과 table에 표현
  $('.dataTables_filter input').keyup(function(){
	  let colIndex = document.querySelector('#select').selectedIndex;
	  table.column(colIndex).search(this.value).draw();
	  
	  let searchCount = table.$('tr', {"filter":"applied"}).length;
	  
  });
});
