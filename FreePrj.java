import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FreePrj extends HttpServlet {
	
	String title0 = "18-24 Year Olds Who Completed High school";
	String title = "Violent Crime";
	String title2 = "People in Poverty";
	String title3 = "Hispanic or Latino Origin";
	String title3_1 = "Black alone";
	String title4 = "Forcible Rape";
	String title5 = "American Indian and Alaska Native alone";
	
	String unit0 = "", unit = "", unit2 = "", unit3 = "", unit3_1 = "", unit4 = "", unit5 = "";
	
	ArrayList<ArrayList<String>> states0 = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> states = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> states2 = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> states3 = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> states3_1 = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> states4 = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> states5 = new ArrayList<ArrayList<String>>();
	
	ArrayList<ArrayList<String>> stateNames = new ArrayList<ArrayList<String>>() {{
			add(new ArrayList<String>() {{add("Alabama");add("AL");add("4858979");}} );
			add(new ArrayList<String>() {{add("Alaska");add("AK");add("738432");}} );
			add(new ArrayList<String>() {{add("Arizona");add("AZ");add("6828065");}} );
			add(new ArrayList<String>() {{add("Arkansas");add("AR");add("2978204");}} );
			add(new ArrayList<String>() {{add("California");add("CA");add("39144818");}} );
			add(new ArrayList<String>() {{add("Colorado");add("CO");add("5456574");}} );
			add(new ArrayList<String>() {{add("Connecticut");add("CT");add("3590886");}} );
			add(new ArrayList<String>() {{add("Delaware");add("DE");add("945934");}} );
			add(new ArrayList<String>() {{add("District of Columbia");add("DC");add("672228");}} );
			add(new ArrayList<String>() {{add("Florida");add("FL");add("20271272");}} );
			add(new ArrayList<String>() {{add("Georgia");add("GA");add("10214860");}} );
			add(new ArrayList<String>() {{add("Hawaii");add("HI");add("1431603");}} );
			add(new ArrayList<String>() {{add("Idaho");add("ID");add("1654930");}} );
			add(new ArrayList<String>() {{add("Illinois");add("IL");add("12859995");}} );
			add(new ArrayList<String>() {{add("Indiana");add("IN");add("6619680");}} );
			add(new ArrayList<String>() {{add("Iowa");add("IA");add("3123899");}} );
			add(new ArrayList<String>() {{add("Kansas");add("KS");add("2911641");}} );
			add(new ArrayList<String>() {{add("Kentucky");add("KY");add("4425092");}} );
			add(new ArrayList<String>() {{add("Louisiana");add("LA");add("4670724");}} );
			add(new ArrayList<String>() {{add("Maine");add("ME");add("1329328");}} );
			add(new ArrayList<String>() {{add("Maryland");add("MD");add("6006401");}} );
			add(new ArrayList<String>() {{add("Massachusetts");add("MA");add("6794422");}} );
			add(new ArrayList<String>() {{add("Michigan");add("MI");add("9922576");}} );
			add(new ArrayList<String>() {{add("Minnesota");add("MN");add("5489594");}} );
			add(new ArrayList<String>() {{add("Mississippi");add("MS");add("2992333");}} );
			add(new ArrayList<String>() {{add("Missouri");add("MO");add("6083672");}} );
			add(new ArrayList<String>() {{add("Montana");add("MT");add("1032949");}} );
			add(new ArrayList<String>() {{add("Nebraska");add("NE");add("1896190");}} );
			add(new ArrayList<String>() {{add("Nevada");add("NV");add("2890845");}} );
			add(new ArrayList<String>() {{add("New Hampshire");add("NH");add("1330608");}} );
			add(new ArrayList<String>() {{add("New Jersey");add("NJ");add("8958013");}} );
			add(new ArrayList<String>() {{add("New Mexico");add("NM");add("2085109");}} );
			add(new ArrayList<String>() {{add("New York");add("NY");add("19795791");}} );
			add(new ArrayList<String>() {{add("North Carolina");add("NC");add("10042802");}} );
			add(new ArrayList<String>() {{add("North Dakota");add("ND");add("756927");}} );
			add(new ArrayList<String>() {{add("Ohio");add("OH");add("11613423");}} );
			add(new ArrayList<String>() {{add("Oklahoma");add("OK");add("3911338");}} );
			add(new ArrayList<String>() {{add("Oregon");add("OR");add("4028977");}} );
			add(new ArrayList<String>() {{add("Pennsylvania");add("PA");add("12802503");}} );
			add(new ArrayList<String>() {{add("Rhode Island");add("RI");add("1056298");}} );
			add(new ArrayList<String>() {{add("South Carolina");add("SC");add("4896146");}} );
			add(new ArrayList<String>() {{add("South Dakota");add("SD");add("858469");}} );
			add(new ArrayList<String>() {{add("Tennessee");add("TN");add("6600299");}} );
			add(new ArrayList<String>() {{add("Texas");add("TX");add("27469114");}} );
			add(new ArrayList<String>() {{add("Utah");add("UT");add("2995919");}} );
			add(new ArrayList<String>() {{add("Vermont");add("VT");add("626042");}} );
			add(new ArrayList<String>() {{add("Virginia");add("VA");add("8382993");}} );
			add(new ArrayList<String>() {{add("Washington");add("WA");add("7170351");}} );
			add(new ArrayList<String>() {{add("West Virginia");add("WV");add("1844128");}} );
			add(new ArrayList<String>() {{add("Wisconsin");add("WI");add("5771337");}} );
			add(new ArrayList<String>() {{add("Wyoming");add("WY");add("586107");}} );
		}}; 

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		PrintWriter out = response.getWriter();

		String html = "";
		
		html += "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">";
		html += "<html>";

		html += "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>";
		html += "<script src=\"http://code.highcharts.com/highcharts.js\"></script>";
//		html += "<script src=\"https://code.highcharts.com/maps/highmaps.js\"></script>";
		html += "<script src=\"http://code.highcharts.com/maps/modules/map.js\"></script>";
//		html += "<script src=\"https://code.highcharts.com/modules/exporting.js\"></script>";
		html += "<script src=\"https://code.highcharts.com/mapdata/countries/us/us-all.js\"></script>";
		
		html += "<head>";
		html += "<title>Raein Hashemi</title>";
		
		html += "</head>\n";
		html += "<body style='font-family: \"Calibri\"'>\n";
		
		html += "<h1 style=\"padding-left: 26%\">US Violent <span style=\"color: red;\">Crime</span> Rate vs <span style=\"color: red;\">Education</span>,"
				+ "<span style=\"color: red;\"> Poverty</span> and <span style=\"color: red;\">Ethnicity</span></h1><br/>";
		
//		html += "<div style=\"color: red; font-size: larger; margin: -33px 0 0 25%;\">Despite some exceptions, poverty and  violent crime rates "
//				+ "seem to be the <span><b>opposite</b></span> of each other.</div><br>"
//				+ "<div style=\"color: red; font-size: larger; margin: -23px 0 0 12%;\">Especially when you look at the <span><b>historical </b></span>"
//				+ "data for each state, you'll see that with poverty going up or down, violent crimes go the <span><b>opposite</b></span> way.</div><br>"
//				+ "<div style=\"color: red; font-size: larger; margin: -13px 0 0 20%;\">This could mean that where there is a bigger difference in the"
//				+ "<span><b> economy</b></span> class, there are more violent crimes.</div>";
		
		html += "<br><div id=\"wrapper\" style=\"width: 80%; height: 600px; margin: 0 auto\">"
				+ "<div id=\"container\" style=\"width: 50%; height: 550px; float: left; margin: 0 auto\"></div>\n"
				+ "<div id=\"container0\" style=\"width: 50%; height: 550px; float: left; margin: 0 auto\"></div>\n"
				+ "</div><br>";
		html += "<div id=\"wrapper\" style=\"width: 87%; " + /*height: 450px;*/ "margin: -90px 0 0 200px;\"><br>"

				+ "<div style=\"font-size: larger; float: left; \">"
				+ "<span style=\"color: red; cursor: pointer;\" onclick=\"mapChart.get('us-nm').select();\"><b>New Mexico</b></span> is the highest with 0.6 %</div>"
				+ "<div style=\"font-size: larger; margin: 0 0 0 45%;\">"
				+ "<span style=\"color: blue; cursor: pointer;\" onclick=\"mapChart0.get('us-vt').select();\"><b>Vermont</b></span> is the highest with 91.3 %</div><br>"
				+ "<div style=\"font-size: larger; float: left; \">"
				+ "<span style=\"color: red; cursor: pointer;\" onclick=\"mapChart.get('us-vt').select();\"><b>Vermont</b></span> is the lowest with 0.1 %</div>"
				+ "<div style=\"font-size: larger; margin: 0 0 0 45%;\">"
				+ "<span style=\"color: blue; cursor: pointer;\" onclick=\"mapChart0.get('us-nm').select();\"><b>New Mexico</b></span> is the lowest with 78.5 %</div><br><br>"
				
				+ "<div id=\"info\" style=\"float: left; width: 35%; " + /*height: 400px;*/ "margin: 0px 0 0 0;\">"
				+ "	<h2></h2>"
				+ "	<div class=\"subheader\" style=\"font-size: large; color: red\">Click states to view history</div>"
				+ "	<div id=\"country-chart\"></div>"
				+ "</div>"
				+ "<div id=\"info0\" style=\"float: left; width: 35%; " + /*height: 400px;*/ "margin: 0px 0 0 0;\">"
				+ "	<h2></h2>"
				+ "	<div class=\"subheader0\" style=\"font-size: large; color: red\">Click states to view history</div>"
				+ "	<div id=\"country-chart0\"></div>"
				+ "</div><br><br>"
				
				+ "<div style=\"font-size: larger; margin: 1% 14% 0 70%; text-align: justify;\"> It seems like adolescents finishing highschool and "
				+ "violent crimes are <span style=\"color: red;\"><b>inversely correlated</b></span>.</div><br>"
				+ "<div style=\"font-size: larger; margin: 0 14% 0 70%; text-align: justify;\">"
				+ "There are some exceptions no doubt, but the majority of states are proportional.</div><br>"
				+ "<div style=\"font-size: larger; margin: 0 14% 0 70%; text-align: justify;\">"
				+ "It also does not necessarily mean that higher education reduces crime rates.</div><br>"
		+ "</div><br><br>";
		
		html += "<br><div id=\"wrapper\" style=\"width: 78%; height: 600px; margin: 0 auto\">"
				+ "<div id=\"container2\" style=\"width: 33%; height: 550px; float: left; margin: 0 auto\"></div>\n"
				+ "<div id=\"container3\" style=\"width: 33%; height: 550px; float: left; margin: 0 auto\"></div>\n"
				+ "<div id=\"container3_1\" style=\"width: 33%; height: 550px; float: left; margin: 0 auto\"></div>\n"
				+ "</div><br>";
		html += "<div id=\"wrapper\" style=\"width: 87%; height: 450px; margin: -90px 0 0 200px;\">"
				+ "<div id=\"info2\" style=\"float: left; width: 65%; " + /*height: 400px;*/ "margin: 0px 0 0 0;\">"
//				+ "	<h2></h2>"
//				+ "	<div class=\"subheader2\" style=\"font-size: large; color: red\">Click states to view history</div>"
				+ "	<div id=\"country-chart20\"></div>"
				+ "</div>"
				+ "<div style=\"font-size: larger; padding-top: -30px; text-align: justify;" + /*height: 400px;*/ " margin: 5% 13% 0 66%; \">"
				+ "The top most percentages in poverty are the top most states with Black and Hispanic ethnicity. </div><br>"
				+ "<div style=\"font-size: larger; padding-top: 0px; text-align: justify;" + /*height: 400px;*/ " margin: 0% 13% 0 66%; \">"
				+ "As shown in the chart, through the years when <span style=\"color: blue;\">Black</span> and <span style=\"color: blue;\">Hispanic </span>"
				+ "percentages go <span><b>up</b></span>, <span style=\"color: red;\">Poverty</span> level goes <span><b>up</b></span> too."
				+ "</div><br>"
				+ "<div style=\"font-size: larger; padding-top: 0px; text-align: justify;" + /*height: 400px;*/ " margin: 0% 13% 0 66%; \">"
				+ "The southern part of the USA was shown to be more violently criminal than the northern states. "
				+ "The poverty level in the southern states is higher as well as percentages of Hispanic and Black inhabitants. "
				+ "So it seems that <span style=\"color: red\">poverty</span> and <span style=\"color: blue\">ethnicity</span> are "
				+ "both correlated with <span style=\"color: red\">violent crimes</span>."
				+ "</div><br>"
//				+ "<div id=\"info3\" style=\"float: left; width: 30%; " + /*height: 400px;*/ "margin: 0px 0 0 0;\">"
//				+ "	<h2></h2>"
//				+ "	<div class=\"subheader3\" style=\"font-size: large; color: red\">Click states to view history</div>"
//				+ "	<div id=\"country-chart3\"></div>"
//				+ "</div>"
//				+ "<div id=\"info3_1\" style=\"float: left; width: 30%; " + /*height: 400px;*/ "margin: 0px 0 0 0;\">"
//				+ "	<h2></h2>"
//				+ "	<div class=\"subheader3_1\" style=\"font-size: large; color: red\">Click states to view history</div>"
//				+ "	<div id=\"country-chart3_1\"></div>"
//				+ "</div>"
		+ "</div><br>";
		
		html += "<div style=\"font-size: x-large; float: left; text-align: justify;" + /*height: 400px;*/ " margin: -2% 11% 0 12%;\">"
				+ "<span style=\"color: red\"><b>Poverty</b></span>, <span style=\"color: blue\"><b>ethnicity</b></span> and "
				+ "lack of highschool <span style=\"color: blue\"><b>education</b></span>"
				+ " are correlated with <span style=\"color: red\"><b>violent crimes</b></span> in the United States."
				+ "</div><br>";
		
		html += "<br><div id=\"wrapper\" style=\"width: 80%; height: 600px; margin: 0 auto\">"
				+ "<div id=\"container4\" style=\"width: 50%; height: 550px; float: left; margin: 0 auto\"></div>\n"
				+ "<div id=\"container5\" style=\"width: 50%; height: 550px; float: left; margin: 0 auto\"></div>\n"
				+ "</div><br>";
		html += "<div id=\"wrapper\" style=\"width: 87%; " + /*height: 450px;*/ "margin: -90px 0 0 200px;\">"
				+ "<div id=\"info4\" style=\"float: left; width: 45%; " + /*height: 400px;*/ "margin: 0px 0 0 0;\">"
				+ "	<h2></h2>"
				+ "	<div class=\"subheader4\" style=\"font-size: large; color: red\">Click states to view history</div>"
				+ "	<div id=\"country-chart4\"></div>"
				+ "</div>"
				+ "<div id=\"info5\" style=\"float: left; width: 45%; " + /*height: 400px;*/ "margin: 0px 0 0 0;\">"
				+ "	<h2></h2>"
				+ "	<div class=\"subheader5\" style=\"font-size: large; color: red\">Click states to view history</div>"
				+ "	<div id=\"country-chart5\"></div>"
				+ "</div><br>"
		+ "</div><br>";
		
		html += "<div style=\"font-size: x-large; float: left; text-align: justify;" + /*height: 400px;*/ " margin: 0px 13% 0 13%;\">"
				+ "The only part we didn't discuss in the violent crime map was Alaska, which is not among the southern states. Here is the "
				+ "correlation of one particular <span style=\"color: red\">violent crime</span> "
				+ "(forcible rape) in this part of the map with Native American <span style=\"color: blue\">ethnicity</span>. "
				+ "However, we cannot say that native amercians did these crimes. They could be the unfortunate victims or there may be another reason."
				+ "</div><br>"				
				
				+ "<div style=\"font-size: x-large; float: left; text-align: justify;" + /*height: 400px;*/ " margin: 2% 13% 0 13%;\">"
				+ "Overall, we saw that adolecents' <span style=\"color: blue\"><b>education</b></span> in highchools seems to have correlation with "
				+ "<span style=\"color: red\"><b>violent crime</b></span> rates. Also <span style=\"color: red\"><b>poverty</b></span> and "
				+ "<span style=\"color: red\"><b>violent crimes</b></span> seem to be proportional as both of their rates are higher in the southern states. "
				+ "<span style=\"color: blue\"><b>Ethnicity</b></span> too seems to be in correlation with <span style=\"color: red\"><b>poverty</b></span>, "
				+ "so it is related to <span style=\"color: red\"><b>violet crimes</b></span> (also because of the correlation between rape and native american rates)."
				+ "</div><br>"
				
				+ "<div style=\"height: 80px; margin: 0; float: left; width: 10px\"></div>";
		
//		html += "<div id=\"wrapper\" style=\"width: 87%; height: 700px; margin: 0 auto\">"
//				+ "<div id=\"container2\" style=\"width: 70%; height: 600px; float: left; margin: 0 auto\"></div>\n";
//		html += "<div id=\"info2\" style=\"float: left; width: 30%; height: 450px; margin: 150px 0 0 0;\">"
//				+ "	<h2></h2>"
//				+ "	<div class=\"subheader2\" style=\"font-size: large; color: red\">Click states to view history</div>"
//				+ "	<div id=\"country-chart2\"></div>"
//				+ "</div>"
//		+ "</div>";
		
//		html += "<div style=\"color: red; font-size: larger; margin: -35px 0 0 15%;\">In the following maps, one or a few states are the "
//				+ "<span><b>indesputable</b></span> leader(s) to others with considerable distance in those categories.</div><br>";
//		html += "<div style=\"color: red; font-size: larger; margin: -15px 0 0 22%;\">Another interesting subject is that some <span><b>neighbors</b></span>"
//				+ " have so many differences in their crime rates.</div><br>";
		
//		html += "<div id=\"wrapper\" style=\"width: 87%; height: 700px; margin: 0 auto\">"
//				+ "<div id=\"container3\" style=\"width: 70%; height: 600px; float: left; margin: 0 auto\"></div>\n";
////				+ "<div id=\"container0\" style=\"width: 50%; height: 600px; float: left; margin: 0 auto\"></div>\n"
//		html += "<div id=\"info3\" style=\"float: left; width: 30%; height: 450px; margin: 150px 0 0 0;\">"
//				+ "	<h2></h2>"
//				+ "	<div class=\"subheader3\" style=\"font-size: large; color: red\">Click states to view history</div>"
//				+ "	<div id=\"country-chart3\"></div>"
//				+ "</div>"
//		+ "</div>";
//		
//		html += "<div id=\"wrapper\" style=\"width: 87%; height: 700px; margin: 0 auto\">"
//				+ "<div id=\"container4\" style=\"width: 70%; height: 600px; float: left; margin: 0 auto\"></div>\n";
////				+ "<div id=\"container0\" style=\"width: 50%; height: 600px; float: left; margin: 0 auto\"></div>\n"
//		html += "<div id=\"info4\" style=\"float: left; width: 30%; height: 450px; margin: 150px 0 0 0;\">"
//				+ "	<h2></h2>"
//				+ "	<div class=\"subheader4\" style=\"font-size: large; color: red\">Click states to view history</div>"
//				+ "	<div id=\"country-chart4\"></div>"
//				+ "</div>"
//		+ "</div>";
//		
//		html += "<div id=\"wrapper\" style=\"width: 87%; height: 700px; margin: 0 auto\">"
//				+ "<div id=\"container5\" style=\"width: 70%; height: 600px; float: left; margin: 0 auto\"></div>\n";
//		html += "<div id=\"info5\" style=\"float: left; width: 30%; height: 450px; margin: 150px 0 0 0;\">"
//				+ "	<h2></h2>"
//				+ "	<div class=\"subheader5\" style=\"font-size: large; color: red\">Click states to view history</div>"
//				+ "	<div id=\"country-chart5\"></div>"
//				+ "</div>"
//		+ "</div>";
		
		html += "<script type=\"text/javascript\">\n";

		html += "$(function () {"							
				
				+ "	   Highcharts.setOptions({"
				+ "	   		global: {"
	            + "	   			useUTC: false"
	            + "	   		}"
	            + "	   });"	            
				
				+ "var mapData = Highcharts.geojson(Highcharts.maps['countries/us/us-all']);"
				+ "$.each(mapData, function () {"
					+ "this.id = this.properties['hc-key'];"
					+ "this.flag = this.id.toLowerCase();"
				+ "});"
					
				+ "	   chart = $('#country-chart20').highcharts({"
				
				+ "				title: {"
				+ "			        text: 'People in Poverty vs Ethnicity',"
			    + "			        x: -40"
			    + "			    },"
				+ "				credits: {"
			    + "			        enabled: false"
			    + "			    },"
			    + "			    subtitle: {"
			    + "			        text: 'in New Mexico and Mississippi',"
			    + "			        x: -40"
			    + "			    },"
			    + "			    xAxis: {"
			    + "			        categories: ['2000', '2001', '2002', '2003', '2004', '2005', '2006', '2007',"
			    + "			            '2008', '2009', '2010', '2011', '2012', '2013']"
			    + "			    },"
			    + "			    yAxis: [{"
			    + "			        title: {"
			    + "			            text: 'Poverty percent'"
			    + "			        },"
			    + "					min: 0,"
			    + "					max: 40,"
			    + "					maxRange: 40,"
			    + "					startOnTick: true,"
			    + "					endOnTick: true"
			    + "			    },{"
			    + "			        title: {"
			    + "			            text: 'Ethnicity percent'"
			    + "			        },"
			    + "					opposite: true,"
			    + "					min: 30,"
			    + "					max: 50,"
			    + "					maxRange: 20,"
			    + "					startOnTick: true,"
			    + "					endOnTick: true"
			    + "			    }],"
			    + "			    tooltip: {"
			    + "			        valueSuffix: ' %'"
			    + "			    },"
			    + "			    legend: {"
			    + "			        layout: 'horizontal',"
			    + "			        align: 'center',"
			    + "			        verticalAlign: 'bottom',"
			    + "			        borderWidth: 0"
			    + "			    },"
			    + "			    series: [{"
			    + "			        name: 'New Mexico Poverty',"
			    + "			        data: [null, null, 17.5, 18, 17.3, 18.4, 18.5, 18.1, 17.1, 19.3, 18.6, 22.2, 20.4, 21.7],"
			    + "					yAxis: 0,"
			    + "					color: 'red'"
			    + "			    }, {"
			    + "			        name: 'New Mexico Latino',"
			    + "			        data: [42.3, 42.7, 43.1, 43.4, 43.7, 44, 44.3, 44.7, 45.2, 45.6, null, null, null, null],"
			    + "					yAxis: 1,"
			    + "					color: 'blue'"
			    + "			    }, {"
			    + "			        name: 'Mississippi Poverty',"
			    + "			        data: [null, null, 17.7, 17.2, 17.3, 21, 21.1, 20.6, 21.2, 23.1, 22.7, 17.4, 22, 22.5],"
			    + "					yAxis: 0,"
			    + "					color: 'rgba(205,92,92,1)'"
			    + "			    }, {"
			    + "			        name: 'Mississippi Black',"
			    + "			        data: [36.4, 36.5, 36.5, 36.5, 36.5, 36.6, 36.9, 37, 37.1, 37.2, null, null, null, null],"
			    + "					yAxis: 1,"
			    + "					color: 'rgba(65,105,225,1)'"
			    + "			    }]"
				
				+ "	   });"
	            
				+ "    mapChart = $('#container').highcharts('Map', {"
	            
				+ "        chart: {"
				+ "            borderWidth : 0"
		        + "        },"
		        
				+ "        title: {"
				+ "           text: '" + title + "',"
				+ "            x: -20"
				+ "        },"
				
				+ "        subtitle: {"
				+ "            text: '" + unit + "',"
				+ "            x: -20"
				+ "        },"
				
				+ "		   credits: {"
				+ "			   enabled: false"
				+ "		   },"
				
				+ "		   mapNavigation: {"
				+ "			   enabled: false,"
				+ "			   enableMouseWheelZoom: false,"
				+ "		   },"
				
				+ "		   colorAxis: {"
				+ "			   min: 100,"
				+ "			   max: 650,"
				+ "			   startOnTick: false,"
				+ "			   endOnTick: false,"
//                + "			   type: 'logarithmic',"
                + "			   minColor: '#FFEEEE',"
                + "			   maxColor: '#220000',"
                + "			   stops: ["
                + "			       [0, '#FFEFEF'],"
                + "			       [0.67, '#FF4444'],"
                + "			       [1, '#220000']"
                + "			   ]"
                + "		   },"
				
				+ "        series: [\n";
		
					html += 	"{"
						+ "			   data: [";
					
					for(ArrayList<String> s : states)
					{
					
						html += "{code: '" + s.get(0) + "', value: " + s.get(1) + ", year: " + s.get(2) + "},";
							
					}
					
					html +=  "],"
						+ "			   mapData: mapData,"
						+ "			   animation: {"
						+ "		       		duration: 1000,"
		                + "			   },"
						
		                + "			   allowPointSelect: true,"
		                
		                + "			   cursor: 'pointer',"
		                + "			   states: {"
		                + "			   		select: {"
                        + "			   			color: 'rgba(164,237,186,0.2)',"
		                + "						borderWidth: 3,"
                        + "			   			borderColor: 'black',"
                        + "			   			dashStyle: 'shortdot'"
                        + "			   		}"
                        + "			   },"
						
		                + "			   mapData: mapData,"
		                + "			   joinBy: ['postal-code', 'code'],"
						
		                + "			   dataLabels: {"
		                + "				   enabled: true,"
		                + "				   color: '#FFFFFF',"
		                + "				   format: '{point.code}'"
		                + "			   },"
						
						+ "            tooltip: {"
				        + "            		headerFormat: '" + title + "<br/>',"
				        + "            		pointFormat: '{point.code}: {point.value:.1f} " + unit + "'"
				        + "            },"
				        
						+ "        },\n";
				
				html += "],"
						+ "    }).highcharts();";
				
				html += "    mapChart0 = $('#container0').highcharts('Map', {"
			            
				+ "        chart: {"
				+ "            borderWidth : 0"
		        + "        },"
		        
				+ "        title: {"
				+ "           text: '" + title0 + "',"
				+ "            x: -20"
				+ "        },"
				
				+ "        subtitle: {"
				+ "            text: '" + unit0 + "',"
				+ "            x: -20"
				+ "        },"
				
				+ "		   credits: {"
				+ "			   enabled: false"
				+ "		   },"
				
				+ "		   mapNavigation: {"
				+ "			   enabled: false,"
				+ "			   enableMouseWheelZoom: false,"
				+ "		   },"
				
				+ "		   colorAxis: {"
				+ "			   min: 75,"
				+ "			   max: 92,"
				+ "			   startOnTick: false,"
				+ "			   endOnTick: false,"
//                + "			   type: 'logarithmic',"
                + "			   minColor: '#EEEEFF',"
                + "			   maxColor: '#000022',"
                + "			   stops: ["
                + "			       [0, '#EFEFFF'],"
                + "			       [0.67, '#4444FF'],"
                + "			       [1, '#000022']"
                + "			   ]"
                + "		   },"
				
				+ "        series: [\n";
		
					html += 	"{"
						+ "			   data: [";
					
					for(ArrayList<String> s : states0)
					{
					
						html += "{code: '" + s.get(0) + "', value: " + s.get(1) + ", year: " + s.get(2) + "},";
							
					}
					
					html +=  "],"
						+ "			   animation: {"
						+ "		       		duration: 1000,"
		                + "			   },"
						
		                + "			   allowPointSelect: true,"
		                
		                + "			   cursor: 'pointer',"
		                + "			   states: {"
		                + "			   		select: {"
                        + "			   			color: 'rgba(164,237,186,0.2)',"
		                + "						borderWidth: 3,"
                        + "			   			borderColor: 'black',"
                        + "			   			dashStyle: 'shortdot'"
                        + "			   		}"
                        + "			   },"
						
		                + "			   mapData: mapData,"
		                + "			   joinBy: ['postal-code', 'code'],"
						
		                + "			   dataLabels: {"
		                + "				   enabled: true,"
		                + "				   color: '#FFFFFF',"
		                + "				   format: '{point.code}'"
		                + "			   },"
						
						+ "            tooltip: {"
				        + "            		headerFormat: '" + title0 + "<br/>',"
				        + "            		pointFormat: '{point.code}: {point.value:.,0f} " + unit0 + "'"
				        + "            },"
				        
						+ "        },\n";
				
				html += "],"
						+ "    }).highcharts();";
				
				html += "    mapChart2 = $('#container2').highcharts('Map', {"
	            
				+ "        chart: {"
				+ "            borderWidth : 0"
		        + "        },"
		        
				+ "        title: {"
				+ "           text: '" + title2 + "',"
				+ "            x: -20,"
				+ "            y: 100"
				+ "        },"
				
				+ "        subtitle: {"
				+ "            text: '" + unit2 + "',"
				+ "            x: -20,"
				+ "            y: 125"
				+ "        },"
				
				+ "		   credits: {"
				+ "			   enabled: false"
				+ "		   },"
				
				+ "		   mapNavigation: {"
				+ "			   enabled: false,"
				+ "			   enableMouseWheelZoom: false,"
				+ "		   },"
				
				+ "		   colorAxis: {"
				+ "			   min: 0,"
				+ "			   max: 26,"
				+ "			   startOnTick: false,"
				+ "			   endOnTick: false,"
//                + "			   type: 'logarithmic',"
                + "			   minColor: '#FFEEEE',"
                + "			   maxColor: '#220000',"
                + "			   stops: ["
                + "			       [0, '#FFEFEF'],"
                + "			       [0.67, '#FF4444'],"
                + "			       [1, '#220000']"
                + "			   ]"
                + "		   },"
				
				+ "        series: [\n";
		
					html += 	"{"
						+ "			   data: [";
					
					for(ArrayList<String> s : states2)
					{
					
						html += "{code: '" + s.get(0) + "', value: " + s.get(1) + ", year: " + s.get(2) + "},";
							
					}
					
					html +=  "],"
						+ "			   animation: {"
						+ "		       		duration: 1000,"
		                + "			   },"
						
		                + "			   allowPointSelect: true,"
		                
		                + "			   cursor: 'default',"
		                + "			   states: {"
		                + "			   		select: {"
                        + "			   			color: 'rgba(164,237,186,0.2)',"
		                + "						borderWidth: 3,"
                        + "			   			borderColor: 'black',"
                        + "			   			dashStyle: 'shortdot'"
                        + "			   		}"
                        + "			   },"
						
		                + "			   mapData: mapData,"
		                + "			   joinBy: ['postal-code', 'code'],"
						
		                + "			   dataLabels: {"
		                + "				   enabled: true,"
		                + "				   color: '#FFFFFF',"
		                + "				   format: '{point.code}'"
		                + "			   },"
						
						+ "            tooltip: {"
				        + "            		headerFormat: '" + title2 + "<br/>',"
				        + "            		pointFormat: '{point.code}: {point.value:.1f} " + unit2 + "'"
				        + "            },"
				        
						+ "        },\n";
				
				html += "],"
						+ "    }).highcharts();";
				
				html += "    mapChart3 = $('#container3').highcharts('Map', {"
			            
				+ "        chart: {"
				+ "            borderWidth : 0"
		        + "        },"
		        
				+ "        title: {"
				+ "           text: '" + title3 + "',"
				+ "            x: -20,"
				+ "            y: 100"
				+ "        },"
				
				+ "        subtitle: {"
				+ "            text: '" + unit3 + "',"
				+ "            x: -20,"
				+ "            y: 125"
				+ "        },"
				
				+ "		   credits: {"
				+ "			   enabled: false"
				+ "		   },"
				
				+ "		   mapNavigation: {"
				+ "			   enabled: false,"
				+ "			   enableMouseWheelZoom: false,"
				+ "		   },"
				
				+ "		   colorAxis: {"
				+ "			   min: 0,"
				+ "			   max: 50,"
				+ "			   startOnTick: false,"
				+ "			   endOnTick: false,"
//                + "			   type: 'logarithmic',"
                + "			   minColor: '#EEEEFF',"
                + "			   maxColor: '#000022',"
                + "			   stops: ["
                + "			       [0, '#EFEFFF'],"
                + "			       [0.67, '#4444FF'],"
                + "			       [1, '#000022']"
                + "			   ]"
                + "		   },"
				
				+ "        series: [\n";
		
					html += 	"{"
						+ "			   data: [";
					
					for(ArrayList<String> s : states3)
					{
					
						html += "{code: '" + s.get(0) + "', value: " + s.get(1) + ", year: " + s.get(2) + "},";
							
					}
					
					html +=  "],"
						+ "			   animation: {"
						+ "		       		duration: 1000,"
		                + "			   },"
						
		                + "			   allowPointSelect: false,"
		                
		                + "			   cursor: 'default',"
		                + "			   states: {"
		                + "			   		select: {"
                        + "			   			color: 'rgba(164,237,186,0.2)',"
		                + "						borderWidth: 3,"
                        + "			   			borderColor: 'black',"
                        + "			   			dashStyle: 'shortdot'"
                        + "			   		}"
                        + "			   },"
						
		                + "			   mapData: mapData,"
		                + "			   joinBy: ['postal-code', 'code'],"
						
		                + "			   dataLabels: {"
		                + "				   enabled: true,"
		                + "				   color: '#FFFFFF',"
		                + "				   format: '{point.code}'"
		                + "			   },"
						
						+ "            tooltip: {"
				        + "            		headerFormat: '" + title3 + "<br/>',"
				        + "            		pointFormat: '{point.code}: {point.value:,.0f} " + unit3 + "'"
				        + "            },"
				        
						+ "        },\n";
				
				html += "],"
						+ "    }).highcharts();";
				
				html += "    mapChart3_1 = $('#container3_1').highcharts('Map', {"
			            
				+ "        chart: {"
				+ "            borderWidth : 0"
		        + "        },"
		        
				+ "        title: {"
				+ "           text: '" + title3_1 + "',"
				+ "            x: -20,"
				+ "            y: 100"
				+ "        },"
				
				+ "        subtitle: {"
				+ "            text: '" + unit3_1 + "',"
				+ "            x: -20,"
				+ "            y: 125"
				+ "        },"
				
				+ "		   credits: {"
				+ "			   enabled: false"
				+ "		   },"
				
				+ "		   mapNavigation: {"
				+ "			   enabled: false,"
				+ "			   enableMouseWheelZoom: false,"
				+ "		   },"
				
				+ "		   colorAxis: {"
				+ "			   min: 0,"
				+ "			   max: 50,"
				+ "			   startOnTick: false,"
				+ "			   endOnTick: false,"
//                + "			   type: 'logarithmic',"
                + "			   minColor: '#EEEEFF',"
                + "			   maxColor: '#000022',"
                + "			   stops: ["
                + "			       [0, '#EFEFFF'],"
                + "			       [0.67, '#4444FF'],"
                + "			       [1, '#000022']"
                + "			   ]"
                + "		   },"
				
				+ "        series: [\n";
		
					html += 	"{"
						+ "			   data: [";
					
					for(ArrayList<String> s : states3_1)
					{
					
						html += "{code: '" + s.get(0) + "', value: " + s.get(1) + ", year: " + s.get(2) + "},";
							
					}
					
					html +=  "],"
						+ "			   animation: {"
						+ "		       		duration: 1000,"
		                + "			   },"
						
		                + "			   allowPointSelect: false,"
		                
		                + "			   cursor: 'default',"
		                + "			   states: {"
		                + "			   		select: {"
                        + "			   			color: 'rgba(164,237,186,0.2)',"
		                + "						borderWidth: 3,"
                        + "			   			borderColor: 'black',"
                        + "			   			dashStyle: 'shortdot'"
                        + "			   		}"
                        + "			   },"
						
		                + "			   mapData: mapData,"
		                + "			   joinBy: ['postal-code', 'code'],"
						
		                + "			   dataLabels: {"
		                + "				   enabled: true,"
		                + "				   color: '#FFFFFF',"
		                + "				   format: '{point.code}'"
		                + "			   },"
						
						+ "            tooltip: {"
				        + "            		headerFormat: '" + title3_1 + "<br/>',"
				        + "            		pointFormat: '{point.code}: {point.value:,.0f} " + unit3_1 + "'"
				        + "            },"
				        
						+ "        },\n";
				
				html += "],"
						+ "    }).highcharts();";
				
				html += "    mapChart4 = $('#container4').highcharts('Map', {"
			            
				+ "        chart: {"
				+ "            borderWidth : 0"
		        + "        },"
		        
				+ "        title: {"
				+ "           text: '" + title4 + "',"
				+ "            x: -20"
				+ "        },"
				
				+ "        subtitle: {"
				+ "            text: '" + unit4 + "',"
				+ "            x: -20"
				+ "        },"
				
				+ "		   credits: {"
				+ "			   enabled: false"
				+ "		   },"
				
				+ "		   mapNavigation: {"
				+ "			   enabled: false,"
				+ "			   enableMouseWheelZoom: false,"
				+ "		   },"
				
				+ "		   colorAxis: {"
				+ "			   min: 15,"
				+ "			   max: 80,"
				+ "			   startOnTick: false,"
				+ "			   endOnTick: false,"
//                + "			   type: 'logarithmic',"
                + "			   minColor: '#FFEEEE',"
                + "			   maxColor: '#220000',"
                + "			   stops: ["
                + "			       [0, '#FFEFEF'],"
                + "			       [0.67, '#FF4444'],"
                + "			       [1, '#220000']"
                + "			   ]"
                + "		   },"
				
				+ "        series: [\n";
		
					html += 	"{"
						+ "			   data: [";
					
					for(ArrayList<String> s : states4)
					{
					
						html += "{code: '" + s.get(0) + "', value: " + s.get(1) + ", year: " + s.get(2) + "},";
							
					}
					
					html +=  "],"
						+ "			   animation: {"
						+ "		       		duration: 1000,"
		                + "			   },"
						
		                + "			   allowPointSelect: true,"
		                
		                + "			   cursor: 'pointer',"
		                + "			   states: {"
		                + "			   		select: {"
                        + "			   			color: 'rgba(164,237,186,0.2)',"
		                + "						borderWidth: 3,"
                        + "			   			borderColor: 'black',"
                        + "			   			dashStyle: 'shortdot'"
                        + "			   		}"
                        + "			   },"
						
		                + "			   mapData: mapData,"
		                + "			   joinBy: ['postal-code', 'code'],"
						
		                + "			   dataLabels: {"
		                + "				   enabled: true,"
		                + "				   color: '#FFFFFF',"
		                + "				   format: '{point.code}'"
		                + "			   },"
						
						+ "            tooltip: {"
				        + "            		headerFormat: '" + title4 + "<br/>',"
				        + "            		pointFormat: '{point.code}: {point.value:,.0f} " + unit4 + "'"
				        + "            },"
				        
						+ "        },\n";
				
				html += "],"
						+ "    }).highcharts();";
				
				html += "    mapChart5 = $('#container5').highcharts('Map', {"
			            
				+ "        chart: {"
				+ "            borderWidth : 0"
		        + "        },"
		        
				+ "        title: {"
				+ "           text: '" + title5 + "',"
				+ "            x: -20"
				+ "        },"
				
				+ "        subtitle: {"
				+ "            text: '" + unit5 + "',"
				+ "            x: -20"
				+ "        },"
				
				+ "		   credits: {"
				+ "			   enabled: false"
				+ "		   },"
				
				+ "		   mapNavigation: {"
				+ "			   enabled: false,"
				+ "			   enableMouseWheelZoom: false,"
				+ "		   },"
				
				+ "		   colorAxis: {"
				+ "			   min: 0,"
				+ "			   max: 15,"
				+ "			   startOnTick: false,"
				+ "			   endOnTick: false,"
//                + "			   type: 'logarithmic',"
                + "			   minColor: '#EEEEFF',"
                + "			   maxColor: '#000022',"
                + "			   stops: ["
                + "			       [0, '#EFEFFF'],"
                + "			       [0.67, '#4444FF'],"
                + "			       [1, '#000022']"
                + "			   ]"
                + "		   },"
				
				+ "        series: [\n";
		
					html += 	"{"
						+ "			   data: [";
					
					for(ArrayList<String> s : states5)
					{
					
						html += "{code: '" + s.get(0) + "', value: " + s.get(1) + ", year: " + s.get(2) + "},";
							
					}
					
					html +=  "],"
						+ "			   animation: {"
						+ "		       		duration: 1000,"
		                + "			   },"
						
		                + "			   allowPointSelect: true,"
		                
		                + "			   cursor: 'pointer',"
		                + "			   states: {"
		                + "			   		select: {"
                        + "			   			color: 'rgba(164,237,186,0.2)',"
		                + "						borderWidth: 3,"
                        + "			   			borderColor: 'black',"
                        + "			   			dashStyle: 'shortdot'"
                        + "			   		}"
                        + "			   },"
						
		                + "			   mapData: mapData,"
		                + "			   joinBy: ['postal-code', 'code'],"
						
		                + "			   dataLabels: {"
		                + "				   enabled: true,"
		                + "				   color: '#FFFFFF',"
		                + "				   format: '{point.code}'"
		                + "			   },"
						
						+ "            tooltip: {"
				        + "            		headerFormat: '" + title5 + "<br/>',"
				        + "            		pointFormat: '{point.code}: {point.value:.1f} " + unit5 + "'"
				        + "            },"
				        
						+ "        },\n";
				
				html += "],"
						+ "    }).highcharts();"
						+ "}); \n";
				
				html += "Highcharts.wrap(Highcharts.Point.prototype, 'select', function (proceed) {"
						
						+ "var countryChart = null;"
						+ "var id = this.series.chart.renderTo.id;"

						+ "proceed.apply(this, Array.prototype.slice.call(arguments, 1));"
				
				            + "if(id == \"container\") {"
				            + "		var points = mapChart.getSelectedPoints();"
				            + "		var infoHeader = $('#info h2');"
				            + "		var infoSubheader = $('#info .subheader');"
				            + "		var cChart = $('#country-chart');"
				            + "		var map = mapChart;"
				            + "		var title = '" + title + "';"
				            + "		var average = 474;"
				            + "		var min = 0;"
				            + "		var max = 1000;"
				            + "		var unit = '" + unit +"';"
				            + "} else if(id == \"container0\") {"
				            + "		var points = mapChart0.getSelectedPoints();"
				            + "		var infoHeader = $('#info0 h2');"
				            + "		var infoSubheader = $('#info0 .subheader0');"
				            + "		var cChart = $('#country-chart0');"
				            + "		var map = mapChart0;"
				            + "		var title = '" + title0 + "';"
			            	+ "		var average = 83;"
				            + "		var min = 60;"
				            + "		var max = 100;"
				            + "		var unit = '" + unit0 +"';"
				            + "} else if(id == \"container2\") {"
				            + "		var points = mapChart2.getSelectedPoints();"
				            + "		var infoHeader = $('#info2 h2');"
				            + "		var infoSubheader = $('#info2 .subheader2');"
				            + "		var cChart = $('#country-chart2');"
				            + "		var map = mapChart2;"
				            + "		var title = '" + title2 + "';"
			            	+ "		var average = 134;"
				            + "		var unit = '" + unit2 +"';"
				            + "} else if(id == \"container3\") {"
				            + "		var points = mapChart3.getSelectedPoints();"
				            + "		var infoHeader = $('#info3 h2');"
				            + "		var infoSubheader = $('#info3 .subheader3');"
				            + "		var cChart = $('#country-chart3');"
				            + "		var map = mapChart3;"
				            + "		var title = '" + title3 + "';"
				            + "		var average = 14.2;"
				            + "		var unit = '" + unit3 +"';"
				            + "} else if(id == \"container3_1\") {"
				            + "		var points = mapChart3_1.getSelectedPoints();"
				            + "		var infoHeader = $('#info3_1 h2');"
				            + "		var infoSubheader = $('#info3_1 .subheader3_1');"
				            + "		var cChart = $('#country-chart3_1');"
				            + "		var map = mapChart3_1;"
				            + "		var title = '" + title3_1 + "';"
				            + "		var average = 12.8;"
				            + "		var unit = '" + unit3_1 +"';"
				            + "} else if(id == \"container4\") {"
				            + "		var points = mapChart4.getSelectedPoints();"
				            + "		var infoHeader = $('#info4 h2');"
				            + "		var infoSubheader = $('#info4 .subheader4');"
				            + "		var cChart = $('#country-chart4');"
				            + "		var map = mapChart4;"
				            + "		var title = '" + title4 + "';"
				            + "		var average = 35.4;"
	                        + "	    var min = 0;"
	                        + "	    var max = 100;"
				            + "		var unit = '" + unit4 +"';"
				            + "} else if(id == \"container5\") {"
				            + "		var points = mapChart5.getSelectedPoints();"
				            + "		var infoHeader = $('#info5 h2');"
				            + "		var infoSubheader = $('#info5 .subheader5');"
				            + "		var cChart = $('#country-chart5');"
				            + "		var map = mapChart5;"
				            + "		var title = '" + title5 + "';"
				            + "		var average = 1;"
	                        + "	    var min = 0;"
	                        + "	    var max = 20;"
				            + "		var unit = '" + unit5 +"';"
				            + "}"
				
				            + "if (points.length) {"
				                + "if (points.length === 1) {"
				                    	+ "infoHeader.html(points[0].name);"
				                + "} else {"
				                		+ "infoHeader.html('Comparing states');"
				                + "}"
				                
			                	+ "infoSubheader.html('<h4>' + title + '</h4><small><em>Shift + Click on map to compare states</em></small>');"
				                
				                + "if (!countryChart) {"
				                    + "countryChart = cChart.highcharts({"
				                        + "chart: {"
				                        + "    height: 250,"
				                        + "    spacingLeft: 0"
				                        + "},"
				                        + "credits: {"
				                        + "    enabled: false"
				                        + "},"
				                        + "title: {"
				                        + "    text: null"
				                        + "},"
				                        + "subtitle: {"
				                        + "    text: null"
				                        + "},"
				                        + "xAxis: {"
				                        + "    tickPixelInterval: 50,"
				                        + "    crosshair: true"
				                        + "},"
				                        + "yAxis: {"
				                        + "    title: {text: unit},"
				                        + "	   min: min,"
				                        + "	   max: max,"
				                        + "	   startOnTick: true,"
				                        + "	   endOnTick: true,"
//				                        + "    minRange: average*1.5,"
				                        + "    floor: 0,"
				                        + "    opposite: true,"
				                        + "	   plotLines: [{"
				                        + "			value: average,"
				                        + "			dashStyle: 'shortdash',"
				                        + "			width: 2,"
				                        + "			zIndex: 3,"
				                        + "			color: 'red',"
				                        + "			label: {"
				                        + "			    text: '<b>' + average + '</b> ' + unit + ((average != 1)? '<br>.<br>' : ' ') + 'US average of entire years',"
				                        + "				y: -12"
				                        + "			}"
				                        + "	   }],"
				                        + "},"				        				
				        				+ "exporting: {"
				        				+ "	   enabled: false"
				        				+ "},"
				                        + "tooltip: {"
				                        + "    shared: true"
				                        + "},"
				                        + "plotOptions: {"
				                        + "    series: {"
				                        + "        animation: {"
				                        + "            duration: 500"
				                        + "        },"
				                        + "        marker: {"
				                        + "            enabled: false"
				                        + "        },"
				                        + "        threshold: 0,"
//				                        + "        pointStart: parseInt(categories[0]),"
				                        + "   }"
				                        + "}"
				                   + "}).highcharts();"
				               + "}"
				
				                + "$.each(points, function (i) {"
				                
				                + "	   var data = [];"
				                
				                + "	   for(k=0; k< map.series[0].data.length; k++)"
				                + "			if(map.series[0].data[k].code == points[i].code)"
				                + "				data.push({x: map.series[0].data[k].year, y: map.series[0].data[k].value});"
				                
				                + "    if (countryChart.series[i]) {"
				                + "        countryChart.series[i].update({"
				                + "            name: this.name,"
				                + "            data: data,"
				                + "            type: points.length > 1 ? 'line' : 'area'"
				                + "        }, false);"
				                + "    } else {"
				                + "        countryChart.addSeries({"
				                + "            name: this.name,"
				                + "            data: data,"
				                + "            type: points.length > 1 ? 'line' : 'area'"
				                + "        }, false);"
				                + "    }"
				                + "});"
				                
				                + "while (countryChart.series.length > points.length) {"
				                + "    countryChart.series[countryChart.series.length - 1].remove(false);"
				                + "}"
				                
				                + "countryChart.redraw();"
				
							+ "} else {"
				            + "    infoHeader.html('');"
				            + "    infoSubheader.html('Click states to view history');"
				            + "    cChart.html('');"
				            + "}"		
				
				     + "});\n";
				
				html += "window.onload = function() {";
				html += "mapChart.get('us-nm').select();";
				html += "mapChart0.get('us-nm').select();";
//				html += "mapChart2.get('us-ms').select();";
//				html += "mapChart3.get('us-la').select();";
//				html += "mapChart3_1.get('us-la').select();";
				html += "mapChart4.get('us-ak').select();";
				html += "mapChart5.get('us-ak').select();";				
				html += "};";

		html += "</script>\n";

		
		html += "</body>\n";
		html += "</html>\n";
		
		out.println(html);
		
		out.close();
		
		out = new PrintWriter("index.jsp");
		
		out.println(html);
		
		out.close();
		
	}
	
	@SuppressWarnings("deprecation")
	public void init() throws ServletException {
		
		InputStream csv;
		
		try {
			csv = new FileInputStream("ObservationData.csv");
			
			Reader decoder = new InputStreamReader(csv, "UTF-8");
			BufferedReader buffered = new BufferedReader(decoder);

			String text = buffered.readLine();
			text = buffered.readLine();
			
			while (text != null) {
				
				DateFormat df = new SimpleDateFormat("d/M/y k:m", Locale.ENGLISH);

				Date date = df.parse(text.substring(text.indexOf("1/"), text.indexOf(",", text.indexOf("1/")) - 1));
				
				String name = text.substring(0, text.indexOf(","));				
				
				for(ArrayList<String> s : stateNames)
				{
					if(s.get(0).toLowerCase().equals(name.toLowerCase()))
					{
						name = s.get(1);
						break;
					}
				}
				
				String abbr = name;
				
				String indicator = text.substring(text.indexOf(",") + 1, text.indexOf(",", text.indexOf(",") + 1)).replace("\"", "");
				
				if(text.contains("Dividends,"))
					indicator = text.substring(text.indexOf(",") + 1, text.indexOf(",", text.indexOf("s,") + 2)).replace("\"", "");
				
				String value = text.substring(text.lastIndexOf(",") + 1);
				
				if(indicator.equals(title))
				{
					unit = text.substring(text.indexOf(",", text.indexOf(",") + 1) + 1, 
							text.indexOf(",", text.indexOf(",", text.indexOf(",") + 1) + 1)).replace("\"", "");
					if(text.contains("100,000"))
						unit = text.substring(text.indexOf(",", text.indexOf(",") + 1) + 1, 
								text.lastIndexOf("\",")).replace("\"", "");
					
					states.add(new ArrayList<String>() {
						{
							add(abbr);							
							add(value);
							add(Integer.toString(date.getYear() + 1900));
						}});
				}
				
				if(indicator.equals(title0))
				{
					unit0 = text.substring(text.indexOf(",", text.indexOf(",") + 1) + 1, 
							text.indexOf(",", text.indexOf(",", text.indexOf(",") + 1) + 1)).replace("\"", "");
					if(text.contains("100,000"))
						unit0 = text.substring(text.indexOf(",", text.indexOf(",") + 1) + 1, 
								text.lastIndexOf("\",")).replace("\"", "");
					
					states0.add(new ArrayList<String>() {
						{
							add(abbr);							
							add(value);
							add(Integer.toString(date.getYear() + 1900));
						}});
				}
				
				if(indicator.equals(title2))
				{
					unit2 = text.substring(text.indexOf(",", text.indexOf(",") + 1) + 1, 
							text.indexOf(",", text.indexOf(",", text.indexOf(",") + 1) + 1)).replace("\"", "");
					if(text.contains("100,000"))
						unit2 = text.substring(text.indexOf(",", text.indexOf(",") + 1) + 1, 
								text.lastIndexOf("\",")).replace("\"", "");
					
					states2.add(new ArrayList<String>() {
						{
							add(abbr);							
							add(value);
							add(Integer.toString(date.getYear() + 1900));
						}});
				}
				
				if(indicator.equals(title3))
				{
					unit3 = text.substring(text.indexOf(",", text.indexOf(",") + 1) + 1, 
							text.indexOf(",", text.indexOf(",", text.indexOf(",") + 1) + 1)).replace("\"", "");
					if(text.contains("100,000"))
						unit3 = text.substring(text.indexOf(",", text.indexOf(",") + 1) + 1, 
								text.lastIndexOf("\",")).replace("\"", "");
					
					states3.add(new ArrayList<String>() {
						{
							add(abbr);							
							add(value);
							add(Integer.toString(date.getYear() + 1900));
						}});
				}
				
				if(indicator.equals(title3_1))
				{
					unit3_1 = text.substring(text.indexOf(",", text.indexOf(",") + 1) + 1, 
							text.indexOf(",", text.indexOf(",", text.indexOf(",") + 1) + 1)).replace("\"", "");
					if(text.contains("100,000"))
						unit3_1 = text.substring(text.indexOf(",", text.indexOf(",") + 1) + 1, 
								text.lastIndexOf("\",")).replace("\"", "");
					
					states3_1.add(new ArrayList<String>() {
						{
							add(abbr);							
							add(value);
							add(Integer.toString(date.getYear() + 1900));
						}});
				}
				
				if(indicator.equals(title4))
				{
					unit4 = text.substring(text.indexOf(",", text.indexOf(",") + 1) + 1, 
							text.indexOf(",", text.indexOf(",", text.indexOf(",") + 1) + 1)).replace("\"", "");
					if(text.contains("100,000"))
						unit4 = text.substring(text.indexOf(",", text.indexOf(",") + 1) + 1, 
								text.lastIndexOf("\",")).replace("\"", "");
					
					states4.add(new ArrayList<String>() {
						{
							add(abbr);							
							add(value);
							add(Integer.toString(date.getYear() + 1900));
						}});
				}
				
				if(indicator.replace("'", "").equals(title5))
				{
					unit5 = text.substring(text.indexOf(",", text.indexOf(",") + 1) + 1, 
							text.indexOf(",", text.indexOf(",", text.indexOf(",") + 1) + 1)).replace("\"", "");
					if(text.contains("100,000"))
						unit5 = text.substring(text.indexOf(",", text.indexOf(",") + 1) + 1, 
								text.lastIndexOf("\",")).replace("\"", "");
					
					states5.add(new ArrayList<String>() {
						{
							add(abbr);							
							add(value);
							add(Integer.toString(date.getYear() + 1900));
						}});
				}
				
				text = buffered.readLine();
				
			}
			
			buffered.close();
			
//			for(ArrayList<String> s : stateNames) {
//				
//				unit0 = "people";
//				
//				states0.add(new ArrayList<String>() {
//					{
//						add(s.get(1));							
//						add(s.get(2));
//						add("2015");
//					}});
//				
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}
	
}
