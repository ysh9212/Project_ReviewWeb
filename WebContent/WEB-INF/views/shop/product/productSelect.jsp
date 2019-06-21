<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../../assets/css/main.css" />
<c:import url="../../temp/bootstrap.jsp" />
<style type="text/css">
.item-topinfowrap{
	position: relative;
	width: 1200px;
	margin:0 auto;
}
.thumb-gallery{
	position: relative;
	float: left;
	width:600px;
	height: 752px;
	margin-right: 50px;
	font-size:0;
}
.thumb-gallery .viewer{
	padding-bottom: 30px;
	overflow: hidden;
}
.thumb-gallery .viewer img {
    min-height: 400px;
    min-width: 400px;
    max-width: 600px;
    max-height: 600px;
    vertical-align: middle;
    background: #fff;
}
.thumb-gallery .viewer li {
    display: none;
    overflow: hidden;
    width: 600px;
    height: 600px;
    text-align: center;
    line-height: 600px;
}
.thumb-gallery .viewer li.on {
    display: block;
}
.item-topinfo{
	float: left;
	width: 550px;
	position: relative;
}
.item-topinfo .shoptit {
    position: relative;
    margin-top: 2px;
    padding-bottom: 12px;
    margin-bottom: 21px;
    border-bottom: 1px solid #a4a9b0;
}
.item-topinfo .rt {
    position: absolute;
    top: 0;
    right: 0;
    font-size: 12px;
    line-height: 18px;
    color: #777;
}
.item-topinfo .shoptit * {
    vertical-align: middle;
    line-height: 22px;
}
.item-topinfo .itemtit {
    width: 420px;
    min-height: 72px;
    margin-bottom: 14px;
    font-size: 28px;
    font-weight: normal;
    color: #000;
    line-height: 36px;
    letter-spacing: -1px;
}
.item-topinfo .item-topinfo_headline .price {
    padding-bottom: 19px;
    position: relative;
    font-size: 28px;
    color: #000;
    line-height: 36px;
    overflow: hidden;
}
.item-topinfo .price_real {
    position: relative;
    display: inline-block;
    font-size: 31px;
    line-height: 36px;
    vertical-align: top;
    height: 36px;
    color: #000;
}
.item_option_area {
    width: 100%;
    position: relative;
    z-index: 4;
}
.form_body {
    padding-top: 26px;
    padding-bottom: 30px;
    margin-bottom: 0;
}
.section_origin_area {
    overflow: hidden;
}
.item_option_area h2.tit_options {
    margin-bottom: 10px;
    letter-spacing: -1px;
    line-height: 16px;
    font-size: 16px;
    font-weight: bold;
    color: #1e2732;
}
.section_origin_area .item-originpd {
    position: relative;
    display: inline-block;
    float: left;
    margin-right: 8px;
    width: 130px;
    height: 38px;
    border-radius: 2px;
    background: #f9f9fa;
    border: 1px solid #efeff0;
}
.bt_increase {
    left: 93px;
    top: 7px;
    background-position: -760px -158px;
}
.bt_decrease {
    left: 13px;
    top: 7px;
    background-position: -704px -158px;
}
.section_origin_area .bt_decrease, .section_origin_area .bt_increase {
    width: 24px;
    height: 24px;
}
.item_option_area .num {
    width: 30px;
    height: 21px;
    margin-left: 30px;
    border: 1px solid #ececec;
    line-height: 21px;
    color: #233549;
    font-size: 14px;
    text-align: center;
}
.section_origin_area .num {
    position: absolute;
    left: 43px;
    top: 5px;
    margin: 0;
    width: 42px;
    height: 26px;
    font-size: 16px;
    color: #233549;
}
.blind {
    display: block;
    overflow: hidden;
    position: absolute;
    top: -999em;
    left: 0;
    font-size: 0;
    line-height: 0;
    text-indent: -999em;
}
.item_option_area .bt_increase, .item_option_area .bt_decrease {
    position: absolute;
    display: block;
    background-position: -48px -74px;
    outline: none;
}
.item-topinfo > .item_option_area .section_bottombtns {
    font-size: 0;
    margin-bottom: 60px;
    vertical-align: top;
}
.vip-content .section_bottombtns button:first-child {
    margin-right: 10px;
}
.btn_white {
    background: #fff !important;
    border: 1px solid #d9d9d9;
    color: #233549;
    margin-right: 10px;
}
.btn_primary {
    display: inline-block;
    width: 270px;
    height: 62px;
    line-height: 62px;
    font-size: 24px;
    box-sizing: border-box;
    font-weight: bold;
    vertical-align: top;
    border-radius: 2px;
}
.btn_blue{
    background: #2e8de5;
    border: 1px solid #217fd7;
    color: #fff;
}
.section_bottombtns button {
    box-shadow: 0 1px 1px rgba(0,0,0,.1);
}
.bt_increase{background:url(//pics.gmarket.co.kr/pc/ko/item/vip/sp_vipgroup.png) no-repeat;}
.bt_decrease{background:url(//pics.gmarket.co.kr/pc/ko/item/vip/sp_vipgroup.png) no-repeat;}
.vip-tabwrap{
	min-width: 1200px;
	margin: 0 auto;
	padding-top: 56px;
	position: relative;
	clear: both;
	z-index: 2;
}
.vip-tabnavi{
	position: absolute;
	width: 100%;
	height: 55px;
	clear: both;
	background: #a9b3bc;
    border-bottom: 1px solid #96a3ad;
    transform: translateZ(0);
    -webkit-transform: translateZ(0);
    top: 0;
    left: 0;
}
.vip-tabwrap .vip-tabnavi ul {
    padding: 13px 0 0;
    height: 46px;
    position: relative;
    overflow: hidden;
}
.vip-tabnavi li {
    float: left;
    margin-right: 4px;
}
.vip-tabnavi .on a {
    font-weight: bold;
    background: #858f9a;
    border-radius: 50px;
    text-decoration: none;
}
.vip-tabnavi a {
    display: block;
    height: 30px;
    padding: 4px 23px;
    color: #fff;
    font-size: 20px;
    line-height: 30px;
    letter-spacing: -1px;
}
.fixed{
	z-index: 5022;
}
.vip-content a {
    color: inherit;
    text-decoration: none;
}
a:link {
text-decoration: none;
}
.vip-tabcontentwrap{
	position: relative;
	z-index: 10;
}
.vip-tab_container{
	position: relative;
    z-index: 10;
    overflow: hidden;
    background: url(//pics.gmarket.co.kr/pc/ko/item/vip/vipline.png) repeat-y right top;
}
.vip-tabcontent_lt {
    float: left;
    padding-top: 40px;
    padding-right: 30px;
    width: 860px;
    border-right: 1px solid #c6cfd7;
}

#vip-tab_detail .smile_delivery_info{width:860px;height:290px;background:url(//pics.gmarket.co.kr/pc/ko/item/vip/vip_img_smiledelivery_freeshipping_v2.png) no-repeat left top;position:relative;}
#vip-tab_detail .smile_delivery_info .btn_more{position:absolute;display:block;width:162px;height:36px;left:50%;bottom:19px;margin-left:-81px;font-size:0;}
#vip-tab_detail .smile_delivery_info .blind{width:0;height:0;}
.vip-detailoption_wrap {
    position: absolute;
    z-index: 5021;
    left: 50%;
    width: 309px;
    height: 830px;
    margin-left: 291px;
    float: right;
}
.vip-detailoption {
    padding: 0;
    position: absolute;
    background: #fff;
    z-index: 10;
    width: 308px;
}
.item_option_area{
	width: 100%;
	position: relative;
	z-index: 4;
}
.section_now_selected{
	position: relative;
	z-index: 40;
}
.select-item{
	z-index: 30;
	margin-bottom: 0;
}
.item_options{
	border: 0;
	border-bottom: 1px solid #d6d7d8;
}
.select-item_option{
	width: 308px;
}
.minishop-selected{
	width: 250px;
}
.txt{
	display: block;
	overflow: hidden;
	text-overflow: ellipsis;
	letter-spacing: -0.5px;
}
.thumb{
	width: 60px;
    height: 60px;
    display: block;
    overflow: hidden;
    border-radius: 2px;
    position: absolute;
    top: 25px;
    left: 19px;
    background: url(//pics.gmarket.co.kr/pc/ko/common/thumb/noimage_60.png) no-repeat center center;
}
.thumb img{
	width: 100%;
}
.item_options button {
    display: block;
    width: 548px;
    font-size: 16px;
    line-height: 22px;
    text-align: left;
    padding: 12px 0 12px 15px;
    background: #fff;
    color: #233549;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}
.vip-detailoption > .item_option_area div.section_now_selected .item_options {
    border: 0;
    border-bottom: 1px solid #d6d7d8;
}
</style>
<script type="text/javascript">
	$(function(){
		
		 $('#increase').click(function(){ 
			    var n = $('#increase').index(this);
			    var num = $("#num:eq("+n+")").val();
			    if(num>=10){
			    	alert('최대 10개 상품 까지 구입 가능 합니다');
			    	return false;
			    }
			    num = $("#num:eq("+n+")").val(num*1+1); 
		});
		$('#decrease').click(function(){ 
				
			    var n = $('#decrease').index(this);
			    var num = $(".num:eq("+n+")").val();
			    if(num<=1){
			    	alert('잘못된 입력입니다');
			    	return false;
			    }
			    num = $(".num:eq("+n+")").val(num*1-1); 
		});
		
		$('#addcart').click(function(){
			location.href = './cartList.jsp';
		});
			  
		$('#purchase').click(function(){
			var member_id = "<%=(String)session.getAttribute("memberDTO")%>"
			if(member_id == 'null'){
				alert('로그인 후 이용 가능합니다');
				return false;
			}else{
			location.href="./productPurchase?pno=";
			}
		});
		
	});

</script>
</head>
<body>
	<%@include file="../../temp/header.jsp"%>
	<div id="page-wrapper">
		<div id="main">
			<div class="container">
				<div class="item-topinfowrap">
					<div class="thumb-gallery">
						<ul class="viewer">
							<li class="on">
								<img alt="상품" src="../../images/hani.jpg" width="600" height="600">
							</li>
						</ul>
					</div><!-- 왼쪽 이미지 -->
					<div class="item-topinfo">
						<div class="item-topinfo_headline">
							<p class="shoptit">
							 UDK 상품
							 <span class="rt">
							 	<span class="pdnum"> 상품 번호 : </span>
							 </span>
							</p>
							<div id="itemcase_basic">
								<h1 class="itemtit">상품 명</h1>
								<p class="price">
								<strong class="price_real">
								가격 : 
								<span class="unit">원</span>
								</strong>
								</p>
							</div>
						</div><!--헤드라인  -->
						<div class="item_option_area">
							<div class="form_body">
								<div class="section_origin_area uxeselectbox" id="noOptionSelectDiv" style="display: block;">
									<h2 class="tit_options">수량</h2>
									<div class="item-originpd">
										<button class="bt_increase" id="increase"><span class="blind">수량증가</span></button>
										<button class="bt_decrease" id="decrease"><span class="blind">수량감소</span></button>
										<input class="num" type="text" id ="num" maxlength="3" title="수량" value="1">
									</div>
									<script type="text/javascript">
    (function(GmktItem, $){
        GmktItem.OrderSetList = GmktItem.OrderSetList || [];
        GmktItem.OrderSetKeyList = GmktItem.OrderSetKeyList || [];
        GmktItem.OrderLimitCntGroup = GmktItem.OrderLimitCntGroup || {};
        GmktItem.OrderSetIndex = GmktItem.OrderSetIndex || 0;

        GmktItem.OptionParamCoreAbove = {
            optOrderSelCnt: 0,
            combOptionDepth: 0,
            txtOrderSelCnt: 0,
            selectedListId: "#coreSelectedList",
            selOptPrefix: "#optOrderSel",
            combOptPrefix: "#optOrderComb",
            txtOptPrefix:"#optOrderTxt",
            calcOptPrefix:"#optOrderTxtCalc",
            plusOptPrefix: "#optOrderPlus"
        };

            
        GmktItem.OptionParamCoreAbove.combOptionObj = null
            

    	GmktItem.OrderLimitCntGroup['1504232177'] = {OrderLimitCnt : 10, OrderPossibleCnt : 10};

        GmktItem.OrderSet = GmktItem.OrderSet || {};
        var OrderSet = GmktItem.OrderSet;

		OrderSet.BaseDiscountPrice = 399000;
        OrderSet.SellPrice = 500000.0000;
        OrderSet.IsCouponAvailable = true;
        OrderSet.CouponBoxAlert = "";

        OrderSet.AuctionNo = 0;
        OrderSet.BranchZipCode = "";
        OrderSet.ClassCode = "";
        OrderSet.ClassKind = "";
        //CPC
        OrderSet.DiscountInfo = [];

        //DiscountBiz 수정 필요해보임.
        
        OrderSet.BaseCostBasisNoArr = [5394109510,5378658351];
		

		OrderSet.DiscountKey = ""

		OrderSet.GiftShopShippingCost = 0;
        OrderSet.GiftShopTransDay = 0;
        OrderSet.InterestGroupNo = 0;
        OrderSet.IsFreeInterestExist =  true;
        OrderSet.IsInstantOrder = false; //조작
        OrderSet.ItemNo = "1504232177";
    	OrderSet.ItemNm = "라이젠노트북ASUS X505ZA-BQ473  5000대완판";
    	OrderSet.GroupIndex = "01";
        OrderSet.Keyword = "";
        OrderSet.KeywordSeq = 0;
		OrderSet.MountBranchSequence = 0; //조작
        OrderSet.OptionInfo = [];
        OrderSet.OrderQty = 1;
        OrderSet.PartnershipCode = "";
        OrderSet.IsCore = true;
        OrderSet.PCID = "W";
        OrderSet.PrePaidType = 1; //조작
        OrderSet.QuickArriveZipCode = "";
        OrderSet.ShippingGroupNo = 37198756; // 조작???
        OrderSet.ShopCode = "";
        OrderSet.ShoppingGuideNo = 0;
        OrderSet.SID = 0;
		OrderSet.UserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36";
        OrderSet.IsCPC = false ;
        OrderSet.SellerCustNo = "122622331";
    	OrderSet.IsSmartDelivery =  false;

    	OrderSet.BranchPrice = 0;
		OrderSet.Discount = {"IsDc":true,"OriginPrice":"500,000","DcPrice":"399,000","SpanCostPrice":"101,000","SpanCostRatePrice":"20","CreditCardDcPrice":"394,000","CreditCardDcRate":"99.9","CreditCardInstantDcCount":"","CreditCardPointDcCount":"","CreditCardInstantDc":[{"Name":"스마일카드 첫결제 혜택","DcPrice":"394,000","DcRate":"99.9","MaxDcPrice":"5,000","MinBasePrice":"5,100"}],"CreditCardPointDc":[],"FreeInterestCardImageHtml":"<img src=\"http://image.gmarket.co.kr/UPLOAD_IMAGE/2019/04/26/G마켓_무이자할부_201905_PC.jpg\">","CardAdditionalBenefitHtml":"<a href=\"https://spweb.gmarket.co.kr/ko/plcc/intro/index?source=ebaykorea&medium=G%5FP%5FWEB%5FH&userType=P\" target=\"_blank\"><img src=\"http://image.gmarket.co.kr/UPLOAD_IMAGE/2018/06/18/스마일카드_제휴카드혜택_노출.jpg\" width=\"318\" height=\"62\" alt=\"스마일카드\"></a>\r\n\r\n<a href=\"http://promotion.gmarket.co.kr/planview/plan.asp?sid=159173\" target=\"_blank\"><img src=\"http://image.gmarket.co.kr/UPLOAD_IMAGE/2018/02/28/지마켓_롯데제휴카드노출수정.jpg\" width=\"318\" height=\"62\" alt=\"e플래티넘 롯데카드\"></a>\r\n\r\n<a href=\"http://rpp.gmarket.co.kr/?exhib=26323\" target=\"_blank\"><img src=\"//image.gmarket.co.kr/UPLOAD_IMAGE/2019/02/01/bn_card_318x62_카카오뱅크.jpg\" width=\"318\" height=\"62\" alt=\"카카오뱅크 프렌즈 체크카드\"></a>","isOutOfStock":false,"hasDC":true,"isCreditCardInstantDc":true,"isCreditCardPointDc":false,"HasFreeInterestCardImage":true,"HasCardAdditionalBenefit":true,"CostBasisNo":"53941095105378658351","CostBasisNm":"7%_고정[상품별할인] 상품번호:1504232177","CostResult":"7.000066000.0000","CostBasisKind":"상품별할인상품별할인","CostUnit":"RM","CostPrice":101000.0,"CostPriceYN":"Y","CostWhoFee":"GDME","DealerCostBasisNo":"","DealerCostPrice":0.0,"Sid":0,"PdcCostPrice":0.0,"DealerCostUnit":null,"DealerCostResult":0,"PersonalCouponMaster":null,"PersonalCouponDetail":null,"DcMasterSeqNo":"0","DcCouponNo":"","UsedZeromarginSale":0.0,"GmarketCostBasisKind":"","IsJaehuCheck":true,"PluralCouponDetail":"","UsedCoupon":"","PosClassCd":"","CustomerNo":"","IsZeroMargin":false,"JaehuId":"","LoginId":"","CustomerTelNo":"enUS","PluralKey":"H8xNQxMTAINOTR01DTMjMTM3LVk1MA0yMzUzTc3fODY1ODM1MX8IfzIwMTkwNjIwfzA5MTE1NC40Mjc5NzAxf39/","CouponBoxAlert":""};

        OrderSet.IsOrderLimit =  true;
        OrderSet.IsECouponTarget = false ;
        OrderSet.IsSmileClub = false;
        OrderSet.IsSmilePay = false;
        OrderSet.IsExpressShop = false;
        OrderSet.MinBuyCount = 1;
        OrderSet.BuyUnitCount = 1;
        OrderSet.MinSellAmount = 8875;
        OrderSet.IsBizOnItem = false;
        OrderSet.IsMountService = false;
        OrderSet.OrderMessage = "";
        OrderSet.HasNoOption = true;
        OrderSet.HasTextOptions = false;

        $(function () {
            $('.item-topinfo .item_options').each(function () {
                $(this).click(function (e) {
                e.preventDefault();
            });
        });

        combOptLayerType = [
            "",
            "",
            ""
        ];

        var selectableOptionController = new GmktItem.SelectableOptionController(GmktItem.OptionParamCoreAbove.selOptPrefix, GmktItem.OptionParamCoreAbove.optOrderSelCnt, GmktItem.OptionParamCoreAbove, "200000502");
        var combinationalOptionController = new GmktItem.CombinationalOptionController(GmktItem.OptionParamCoreAbove.combOptPrefix, GmktItem.OptionParamCoreAbove.combOptionDepth, GmktItem.OptionParamCoreAbove.combOptionObj, GmktItem.OptionParamCoreAbove, combOptLayerType[0], combOptLayerType[1], combOptLayerType[2], "200000502");
        var calculationalOptionController = new GmktItem.CalculationalOptionController(GmktItem.OptionParamCoreAbove.calcOptPrefix, GmktItem.OptionParamCoreAbove, "200000506");
        var textOptionController = new GmktItem.TextOptionController(GmktItem.OptionParamCoreAbove.txtOptPrefix, GmktItem.OptionParamCoreAbove, "200000505");
        new GmktItem.NoOptionController("#noOptionSelectDiv", GmktItem.OptionParamCoreAbove);

        GmktItem.OptionParamCoreAbove.optionInitializer = new GmktItem.OptionInitializer(selectableOptionController, combinationalOptionController, textOptionController, calculationalOptionController);
        selectableOptionController.enableOptionChain();
        combinationalOptionController.enableOptionChain();
        calculationalOptionController.enableOption();
        textOptionController.enableOption();



        GmktItem.PlusOptionPool = GmktItem.PlusOptionPool || {};
    });

    })(window.GmktItem = window.GmktItem || {}, jQuery);

</script>
								</div>
							</div><!-- form body  -->
							<div class="form_bottom">
						        <div class="section_bottombtns">
                				<button class="btn_primary btn_white btn_mycart"  id="addcart" ><em>장바구니</em></button>
                				<button class="btn_primary btn_blue"  id="purchase" ><em>구매하기</em></button>
								
                    
       					 		</div>
								<div class="tooltip_priceguide tooltip_layer">
									<div class="arrowtop_tooltip">
										<h4 class="tit_tooltip hidden">총상품금액 안내</h4>
										<a href="#" class="tooltip_hide"><i class="btn_close"><span class="blind">닫기</span></i></a>
										<div class="tooltip_content">
											<div class="tooltip_default_area">
												<p>
													총 상품금액에 <em>배송비는 포함되어 있지	않습니다.</em> 결제시 조건에 따라 배송비가 추가 
													될 수 있습니다.
												</p>
											</div>
										</div>
									</div>
								</div>
						    </div>
							
						</div>
					</div>
				</div><!--item-topinfowrap  -->
			
				<div class="vip-tabwrap">
					<div class="vip-tabnavi fixed" style="top:0px;">
						<ul>
							<li class="on"><a href="#">상세설명</a>
							</li>
							<li><a href="#">상품평</a></li>
							<li><a href="#">교환/반품</a></li>
						</ul>
					</div>
					<div class="vip-tabcontentwrap">
					<div class="vip-tab_container">
						<div id="vip-tab_detail" class="vip-tabcontent_lt on vip-tabcontent">
						상품 설명
						<img alt="hani" src="../../images/hani.jpg">
						</div>

							<div class="vip-detailoption_wrap">
								<div class="vip-detailoption">
									<div class="item_option_area">
										<div class="form_top">
											<div class="select-item">
												<span class="txt minishop-selected">
												 <span class="thumb"> 
												 <img src="../../images/hani.jpg" width="60" height="60" alt="썸네일"> 상품 제목 또는 설명
												</span> 
													<span class="info"> 
														<span class="item_tit">	
														상품 제목 
														</span>
													</span>
												</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div><!--상세내용  -->
				
				</div><!--container  -->
		</div><!--main  -->
	</div><!-- pagewrapper -->
	<%@include file= "../../temp/footer.jsp" %>
</body>
</html>