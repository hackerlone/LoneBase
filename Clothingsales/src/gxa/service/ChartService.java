package gxa.service;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ChartService {
	public void processImg(HttpServletRequest request) {
		JFreeChart chart = null;
	    String url = (String)request.getAttribute("url");//获取原跳转路径
		String type= (String)request.getAttribute("type");
		//柱状图
		//dcd为柱状图的数据集
		String chartname = (String)request.getAttribute("chartname");
		String itemname = (String)request.getAttribute("itemname");
		String itemval = (String)request.getAttribute("itemval");
		String imgname =(String)request.getAttribute("imgname");
		if (type.equals("bar")) {

			DefaultCategoryDataset dcd = (DefaultCategoryDataset) request
					.getAttribute("dcd");
			ChartFactory.createBarChart3D(chartname, itemname, itemval, dcd,
					PlotOrientation.VERTICAL, true, true, true);
			chart = ChartFactory.createBarChart3D(chartname, itemname, itemval,
					dcd, PlotOrientation.VERTICAL, true, true, true);
			// CategoryPlot categoryplot = chart.getCategoryPlot(); //获得
			// plot：CategoryPlot！！
			chart.getTitle().setFont(new Font("宋体", 0, 12));
			CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
			NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
			CategoryAxis domainAxis = categoryplot.getDomainAxis();
			TextTitle textTitle = chart.getTitle();

			textTitle.setFont(new Font("黑体", Font.PLAIN, 20));

			domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));

			domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));

			numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));

			numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));

			chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));

			BarRenderer3D renderer = new BarRenderer3D();

			// 设置每个地区所包含的平行柱的之间距离
			renderer.setItemMargin(0.1);
			// 显示每个柱的数值，并修改该数值的字体属性
			// renderer.setItemLabelGenerator(new
			// StandardCategoryItemLabelGenerator());
			// renderer.setItemLabelsVisible(true);

			categoryplot.setRenderer(renderer);
		} else if (type.equals("pie")) {
			// //饼图的数据集
			DefaultPieDataset dpd = (DefaultPieDataset) request
					.getAttribute("dpd");
			// new DefaultPieDataset();
			// dpd.setValue("1班", 10);
			// dpd.setValue("2班", 3);
			// dpd.setValue("3班", 4);
			// dpd.setValue("4班", 3);

			// (DefaultPieDataset)ServletActionContext.getRequest().getSession().getAttribute("dpd");

			// 使用工厂类创建饼图
			chart = ChartFactory.createPieChart3D(chartname, dpd, true, true,
					false);

			PiePlot pieplot = (PiePlot) chart.getPlot();
			pieplot.setLabelFont(new Font("SansSerif", 0, 12));
			chart.getTitle().setFont(new Font("SansSerif", 0, 12));
			chart.getLegend().setItemFont(new Font("SansSerif", 0, 12));

		}
		String realPath = request.getRealPath("/upload");
		imgname = imgname + type + ".png";
		OutputStream os;
		try {
			os = new FileOutputStream(realPath + "\\" + imgname);
			ChartUtilities.writeChartAsPNG(os, chart, 600, 460);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("imgname", imgname);
		if (type.equals("bar")) {
			request.setAttribute("imgnamebar", imgname);
		} else if (type.equals("pie")) {
			request.setAttribute("imgnamepie", imgname);
		}
	}
}
