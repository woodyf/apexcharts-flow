package com.github.appreciated.apexcharts;

import com.github.appreciated.apexcharts.config.builder.ChartBuilder;
import com.github.appreciated.apexcharts.config.builder.LegendBuilder;
import com.github.appreciated.apexcharts.config.builder.ResponsiveBuilder;
import com.github.appreciated.apexcharts.config.builder.TitleSubtitleBuilder;
import com.github.appreciated.apexcharts.config.chart.Type;
import com.github.appreciated.apexcharts.config.legend.Position;
import com.github.appreciated.apexcharts.config.responsive.builder.OptionsBuilder;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class DemoView extends HorizontalLayout {
	final VerticalLayout main = new VerticalLayout();

	public DemoView() {
		final String[] labels = { "Team A", "Team B", "Team C", "Team D", "Team E" };
		
		final ApexChartsBuilder acb = new ApexChartsBuilder().withChart(ChartBuilder.get().withType(Type.pie).build())
				.withLabels(labels).withLegend(LegendBuilder.get().withPosition(Position.right).build())
				.withSeries(44.0, 55.0, 13.0, 43.0, 22.0)
				.withResponsive(ResponsiveBuilder.get().withBreakpoint(480.0)
						.withOptions(OptionsBuilder.get()
								.withLegend(LegendBuilder.get().withPosition(Position.bottom).build()).build())
						.build())
				.withTitle(TitleSubtitleBuilder.get().withText("DEMO").build());
		final ApexCharts chart = acb.build();
		
		chart.setHandleClickOnIndex(idx -> System.out.println(labels[idx] + " clicked"));
		main.add(chart);

		setSizeFull();
		getStyle().set("overflow", "auto");
		setSizeUndefined();
		add(main);
		main.setHeight("unset");
		main.setWidth("100%");
	}

}
