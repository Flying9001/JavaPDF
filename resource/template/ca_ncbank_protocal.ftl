<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
<html xmlns="http://www.w3.org/1999/xhtml">  
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf8"></meta>
  <title>借 款 协 议</title>
  <style>
  	body {  min-width: 1000px;      
  			width:1000px;
			font-family: Microsoft YaHei,SimSun;
			font-size:18px;
			color:#333333;
			background-color:#fff;
			word-break:break-all; 
			word-wrap : break-word;
			overflow:auto;
	}  
	div,p,span,a{
			width:1000px;
			word-break:break-all; 
			word-wrap : break-word;
			overflow:auto;
			text-indent:24.0pt;
	}
	#links_foot_first {
		font-size:16px; color:#FFFFFF;
		}
     table {
    		 width:100%;
     }
     @page {  
          size: 12in 11in; 
          @bottom-right {
				content: counter(page) " /  " counter(pages);
		  }
     }
  </style>
</head>
<body class="f16 lh30">
<#-- ------------------新版本------------------ -->
<h1 style="text-align:center;" class="mb50">
 借 款 协  议
</h1>
<div>
	<#-- 出借人 -->
	<ul>
		<li><b>甲方（出借人）:</b>
		<#if isBorrower = 1>
			<#-- 借款人 -->
			formatTenderUserTableHtml1
		</#if>
		</li>
		<!-- 投资人 -->
		<#if isBorrower = 0>
			<li>真实姓名：{currentUserMap.real_name}</li>
			<li>身份证号：{currentUserMap.card}</li>
			<li>用户名： {currentUserMap.username}</li>
			<li>充值帐户信息： {currentUserMap.cardnbr}</li>
		</#if>
	</ul>
	<#-- 借款人 -->
	<ul class="mt15">
		<li><b>乙方（借款人）:</b></li>
		<li>姓名／单位：：{borrowUserinfo.real_name}</li>
		<li>身份证号／营业执照：{borrowUserinfo.card}</li>
		<li>用户名： {borrowInfo.username}</li>
		<li>充值帐户信息：{borrowUserinfo.cardnbr}</li>
	</ul>
	<#-- 中介 -->
	<ul class="mt15">
		<li>丙方（互联网金融平台）：赣州发展融通资产管理有限公司</li>
		<li>办公场所：江西省赣州市章贡区赣江源大道25号三和悦城1栋8楼</li>
		<li>全国400免费热线：400-8926-399</li>
	</ul>
</div>

<div class="mt15">
鉴于： 
<ul>
	<li>1、丙方是一家在江西省赣州市合法成立并有效存续的有限责任公司，是一家专业从事互联网金融信息咨询服务公司；</li>
	<li>2、乙方已在丙方投资运营的互联网金融平台网站（www.rongtongzc.com)或手机客户端（APP）注册，并承诺其提供给丙方的信息是真实、完整和有效的； </li>
	<li>3、甲方承诺对本协议涉及的出借资金是具有完全的支配能力，是其自有闲散资金，为其合法所得；并承诺其提供给丙方的信息是真实、完整和有效的；</li>
	<li>4、乙方有借款/融资需求，甲方亦同意出借款项，双方有意成立借贷关系。</li>
</ul>
各方经协商一致，签订如下协议，共同遵照履行： 
</div>
<div class="f16 mt5"><b>第一条 	借款基本信息</b> </div>
<div>

	<#if isBorrower = 0>
	<#-- 出借人 -->
		<table class="mb5" cellspacing="0" rules="all" border="1" >
			<tr height="20">
				<td class="tc">出借人姓名</td>
				<td class="tc">出借本金</td>
				<td class="tc" width="12%">起息日</td>
				<td class="tc">期限</td>
				<td class="tc" width="12%">借款到期日</td>
				<td class="tc" width="15%">借款年化利率</td>
				<td class="tc" width="15%">本息偿还方式</td>
				<td class="tc">应收本息</td>
			</tr>
		
		
		</table>
		
	<#else>
	<#-- 借款人 -->
		<table class="mb5" cellspacing="0" rules="all" border="1" >
			<tr height="20">
				<td class="tc">出借人姓名</td>
				<td class="tc">身份证号</td>
				<td class="tc">出借本金</td>
				<td class="tc" width="12%">起息日</td>
				<td class="tc">期限</td>
				<td class="tc">应收本息</td>
			</tr>
			
			<tr>
				<td class="tc">总计</td>
				<td class="tc"></td>
				<td class="tc">{borrowInfo.total}元</td>
				<td class="tc"></td>
				<td class="tc">
				</td>
				<td class="tc">{borrowInfo.repay_total}元</td>
			</tr>
			</table>
	</#if>

<div>注：
<ul>
	<li>1、因甲乙双方借贷关系存在多对一的情况，借款金额以甲方通过丙方平台实际投标金额为准。</li>
	<li>2、充值账户是指甲乙双方在江西银行开立的用于充值和提现的电子账户。</li>
	<li>3、起息日遇节假日，计息规则不变。</li>
</ul>
</div>
</div>
<#--
------------------新版本------------------ -->
    <div>{article.content}</div>
  <div> 
	     <table> 
		    <tr>
		          <td class="ta2" style="position: relative;height:135px;font-size:25px"><span  style="no-repeat;height:151px;text-align: right;position: absolute;width: 151px;left: 10%;top: -20px;"></span>
		             乙方：<a id="links_foot_first">电子签章借款章专用</a></td>
		    </tr> 
		    <tr>  
			  <td class="ta2" style="position: relative;height:135px;font-size:25px"><span  style="no-repeat;height:151px;text-align: right;position: absolute;width: 151px;left: 10%;top: -20px;"></span>
		             丙方：<a id="links_foot_first">电子签章公司章专用</a></td>
		    </tr>
		    
		    <#assign n=0/>
		    <#list testLists as lists>
		    
		   <tr>
		       ${n}
		       <#assign n=n+1/>
		       ${n}
			   <#if n == 1>
			   <td class="ta2" style="position: relative;height:135px;font-size:25px"><span  style="no-repeat;height:151px;text-align: right;position: absolute;width: 151px;left: 10%;top: -20px;"></span>
			     甲方：${lists}</td>
			  <#else>
			  	<td class="ta2" style="position: relative;height:135px;font-size:25px"><span  style="no-repeat;height:151px;text-align: right;position: absolute;width: 151px;left: 10%;top: -20px;"></span>
			    1111111 ${lists}</td>
		      </#if>
			   
		    </tr>
		  </#list>
		    
		    
	    </table>
</div>
	<div style="text-align: right;position: relative;width: 1000px;margin-top:-5px;">
	<p>{addDay}</p>
	</div>
</body>
</html> 