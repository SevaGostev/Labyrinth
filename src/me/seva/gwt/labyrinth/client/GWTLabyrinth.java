package me.seva.gwt.labyrinth.client;

import me.seva.gwt.labyrinth.shared.FieldVerifier;

import java.util.LinkedHashMap;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
//import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ArrowStyle;
import com.smartgwt.client.types.DragAppearance;  
import com.smartgwt.client.types.Overflow;  
import com.smartgwt.client.widgets.Canvas;  
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Slider;
import com.smartgwt.client.widgets.drawing.DrawCurve;
import com.smartgwt.client.widgets.drawing.DrawLabel;
import com.smartgwt.client.widgets.drawing.DrawLine;
import com.smartgwt.client.widgets.drawing.DrawLinePath;
import com.smartgwt.client.widgets.drawing.DrawOval;
import com.smartgwt.client.widgets.drawing.DrawPane;
import com.smartgwt.client.widgets.drawing.DrawPath;
import com.smartgwt.client.widgets.drawing.DrawRect;
import com.smartgwt.client.widgets.drawing.DrawSector;
import com.smartgwt.client.widgets.drawing.DrawTriangle;
import com.smartgwt.client.widgets.drawing.Point;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.events.ValueChangedEvent;
import com.smartgwt.client.widgets.events.ValueChangedHandler;
import com.smartgwt.client.widgets.form.DynamicForm;  
import com.smartgwt.client.widgets.form.fields.CheckboxItem;  
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;  
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;  
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;  
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.VStack;  

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTLabyrinth implements EntryPoint
{
	public static final double CELL_WIDTH  = 50;
	public static final double CELL_HEIGHT = 50;
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	private DrawPane drawPane;
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()
	{
		drawPane = new DrawPane();  
        drawPane.setHeight(400);    
        drawPane.setDrawingHeight(CELL_HEIGHT * (maze.getHeight()+4));
        drawPane.setDrawingWidth(CELL_WIDTH * (maze.getWidth()+4)); 
        drawPane.setTranslate(new int[] {10, 10});  
        drawPane.setShowEdges(true);  
        drawPane.setEdgeSize(4);  
        drawPane.setBackgroundColor("papayawhip");  
        drawPane.setCanDragScroll(true);  
        drawPane.setZoomLevel(1.5);  
  
        drawPane.addDrawHandler(new DrawHandler() {  
            @Override  
            public void onDraw(DrawEvent event) {  
  
                DrawPane drawPane = (DrawPane) event.getSource();  
  
                DrawLine refLineX = new DrawLine();  
                refLineX.setDrawPane(drawPane);  
                refLineX.setStartPoint(new Point(0,0));  
                refLineX.setEndPoint(new Point(100,0));  
                refLineX.setLineWidth(1);  
                refLineX.setLineColor("#ff0000");  
                refLineX.setEndArrow(ArrowStyle.OPEN);  
                refLineX.draw();  
  
                DrawLabel refLineXLabel = new DrawLabel();  
                refLineXLabel.setDrawPane(drawPane);  
                refLineXLabel.setLeft(110);  
                refLineXLabel.setTop(10);  
                refLineXLabel.setFontFamily("Arial");  
                refLineXLabel.setFontSize(14);  
                refLineXLabel.setFontWeight("normal");  
                refLineXLabel.setLineColor("#ff0000");  
                refLineXLabel.setContents("X");  
                refLineXLabel.draw();  
  
                DrawLine refLineY = new DrawLine();  
                refLineY.setDrawPane(drawPane);  
                refLineY.setStartPoint(new Point(0,0));  
                refLineY.setEndPoint(new Point(0,100));  
                refLineY.setLineWidth(1);  
                refLineY.setLineColor("#ff0000");  
                refLineY.setEndArrow(ArrowStyle.OPEN);  
                refLineY.draw();  
  
                DrawLabel refLineYLabel = new DrawLabel();  
                refLineYLabel.setDrawPane(drawPane);  
                refLineYLabel.setLeft(10);  
                refLineYLabel.setTop(110);  
                refLineYLabel.setFontFamily("Arial");  
                refLineYLabel.setFontSize(14);  
                refLineYLabel.setFontWeight("normal");  
                refLineYLabel.setLineColor("#ff0000");  
                refLineYLabel.setContents("Y");  
                refLineYLabel.draw();  
  
                DrawOval refOval = new DrawOval();  
                refOval.setDrawPane(drawPane);  
                refOval.setCenterPoint(new Point(0, 0));  
                refOval.setRadius(4);  
                refOval.setFillColor("#ff0000");  
                refOval.setLineColor(null);  
                refOval.draw();  
  
                DrawLabel refOvalLabel = new DrawLabel();  
                refOvalLabel.setDrawPane(drawPane);  
                refOvalLabel.setLeft(5);  
                refOvalLabel.setTop(5);  
                refOvalLabel.setFontFamily("Arial");  
                refOvalLabel.setFontSize(14);  
                refOvalLabel.setFontWeight("normal");  
                refOvalLabel.setLineColor("#ff0000");  
                refOvalLabel.setContents("(0, 0)");  
                refOvalLabel.draw();  
                  
                DrawLabel triangleLabel = new DrawLabel();  
                triangleLabel.setDrawPane(drawPane);  
                triangleLabel.setLeft(50);  
                triangleLabel.setTop(175);  
                triangleLabel.setContents("Triangle");  
                triangleLabel.draw();  
  
                DrawTriangle drawTriangle = new DrawTriangle();  
                drawTriangle.setDrawPane(drawPane);  
                drawTriangle.setPoints(new Point(100,50),new Point(150,150),new Point(50,150));  
                drawTriangle.draw();  
  
                DrawLabel curveLabel = new DrawLabel();  
                curveLabel.setDrawPane(drawPane);  
                curveLabel.setLeft(200);  
                curveLabel.setTop(175);  
                curveLabel.setContents("Curve");  
                curveLabel.draw();  
  
                DrawCurve drawCurve = new DrawCurve();  
                drawCurve.setDrawPane(drawPane);  
                drawCurve.setStartPoint(new Point(200,50));  
                drawCurve.setEndPoint(new Point(300,150));  
                drawCurve.setControlPoint1(new Point(250,0));  
                drawCurve.setControlPoint2(new Point(250,200));  
                drawCurve.draw();  
  
                DrawLabel linePathLabel = new DrawLabel();  
                linePathLabel.setDrawPane(drawPane);  
                linePathLabel.setLeft(350);  
                linePathLabel.setTop(175);  
                linePathLabel.setContents("Line Path");  
                linePathLabel.draw();  
  
                DrawLinePath drawLinePath = new DrawLinePath();  
                drawLinePath.setDrawPane(drawPane);  
                drawLinePath.setStartPoint(new Point(350,50));  
                drawLinePath.setEndPoint(new Point(450,150));  
                drawLinePath.draw();  
  
                DrawLabel pathLabel = new DrawLabel();  
                pathLabel.setDrawPane(drawPane);  
                pathLabel.setLeft(500);  
                pathLabel.setTop(175);  
                pathLabel.setContents("Path");  
                pathLabel.draw();  
  
                DrawPath drawPath = new DrawPath();  
                drawPath.setDrawPane(drawPane);  
                drawPath.setPoints(  
                        new Point(500,50),  
                        new Point(525,50),  
                        new Point(550,75),  
                        new Point(575,75),  
                        new Point(600,75),  
                        new Point(600,125),  
                        new Point(575,125),  
                        new Point(550,125),  
                        new Point(525,150),  
                        new Point(500,150)  
                );  
                drawPath.draw();  
  
                DrawLabel ovalLabel = new DrawLabel();  
                ovalLabel.setDrawPane(drawPane);  
                ovalLabel.setLeft(50);  
                ovalLabel.setTop(415);  
                ovalLabel.setContents("Oval");  
                ovalLabel.draw();  
  
                DrawOval drawOval = new DrawOval();  
                drawOval.setDrawPane(drawPane);  
                drawOval.setLeft(50);  
                drawOval.setTop(300);  
                drawOval.setWidth(100);  
                drawOval.setHeight(100);  
                drawOval.draw();  
  
                DrawLabel rectLabel = new DrawLabel();  
                rectLabel.setDrawPane(drawPane);  
                rectLabel.setLeft(200);  
                rectLabel.setTop(415);  
                rectLabel.setContents("Rect");  
                rectLabel.draw();  
  
                DrawRect drawRect = new DrawRect();  
                drawRect.setDrawPane(drawPane);  
                drawRect.setLeft(200);  
                drawRect.setTop(300);  
                drawRect.setWidth(150);  
                drawRect.setHeight(100);  
                drawRect.draw();  
  
                DrawLabel lineLabel = new DrawLabel();  
                lineLabel.setDrawPane(drawPane);  
                lineLabel.setLeft(400);  
                lineLabel.setTop(415);  
                lineLabel.setContents("Line");  
                lineLabel.draw();  
  
                DrawLine drawLine = new DrawLine();  
                drawLine.setDrawPane(drawPane);  
                drawLine.setStartPoint(new Point(400,300));  
                drawLine.setEndPoint(new Point(500,400));  
                drawLine.draw();  
  
                DrawLabel sectorLabel = new DrawLabel();  
                sectorLabel.setDrawPane(drawPane);  
                sectorLabel.setLeft(550);  
                sectorLabel.setTop(415);  
                sectorLabel.setContents("Sector");  
                sectorLabel.draw();  
  
                DrawSector drawSector = new DrawSector();  
                drawSector.setDrawPane(drawPane);  
                drawSector.setCenterPoint(new Point(550,300));  
                drawSector.setStartAngle(0.0);  
                drawSector.setEndAngle(90.0);  
                drawSector.setRadius(100);  
                drawSector.draw();  
            }  
        });  
  
        ValueChangedHandler paneRotationSliderValueChangeHandler = new ValueChangedHandler() {  
            @Override  
            public void onValueChanged(ValueChangedEvent event) {  
                if (drawPane.isCreated()) {  
                    drawPane.rotate(event.getValue());  
                }  
            }  
        };  
  
        Slider paneRotationSlider = new Slider();  
        paneRotationSlider.setMinValue(0.0);  
        paneRotationSlider.setMaxValue(360.0);  
        paneRotationSlider.setNumValues(360);  
        paneRotationSlider.setWidth(400);  
        paneRotationSlider.setValue(0.0);  
        paneRotationSlider.setTitle("Rotate Pane");  
        paneRotationSlider.setLabelWidth(110);  
        paneRotationSlider.setVertical(false);  
        paneRotationSlider.addValueChangedHandler(paneRotationSliderValueChangeHandler);  
  
        ValueChangedHandler zoomSliderValueChangeHandler = new ValueChangedHandler() {  
            @Override  
            public void onValueChanged(ValueChangedEvent event) {  
                if (drawPane.isCreated()) {  
                    drawPane.zoom(event.getValue());  
                }  
            }  
        };  
  
        Slider zoomSlider = new Slider();  
        zoomSlider.setMinValue(0.1);  
        zoomSlider.setMaxValue(3.0);  
        zoomSlider.setNumValues(300);  
        zoomSlider.setWidth(400);  
        zoomSlider.setValue(1.5);  
        zoomSlider.setRoundValues(false);  
        zoomSlider.setRoundPrecision(2);  
        zoomSlider.setTitle("Zoom Shapes");  
        zoomSlider.setLabelWidth(110);  
        zoomSlider.setVertical(false);  
        zoomSlider.addValueChangedHandler(zoomSliderValueChangeHandler);  
  
        VStack layout = new VStack();  
        layout.setWidth100();  
        layout.setMembersMargin(15);  
        layout.addMember(drawPane);  
        layout.addMember(zoomSlider);  
        layout.addMember(paneRotationSlider);  
  
        layout.draw();
		
/*		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler
		{
			 //Fired when the user clicks on the sendButton.
			public void onClick(ClickEvent event)
			{
				sendNameToServer();
			}

			//Fired when the user types in the nameField.

			public void onKeyUp(KeyUpEvent event)
			{
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER)
				{
					sendNameToServer();
				}
			}

			 //Send the name from the nameField to the server and wait for a response.

			private void sendNameToServer()
			{
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer))
				{
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer, new AsyncCallback<String>()
				{
					public void onFailure(Throwable caught)
					{
						// Show the RPC error message to the user
						dialogBox.setText("Remote Procedure Call - Failure");
						serverResponseLabel.addStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(SERVER_ERROR);
						dialogBox.center();
						closeButton.setFocus(true);
					}

					public void onSuccess(String result)
					{
						dialogBox.setText("Remote Procedure Call");
						serverResponseLabel.removeStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(result);
						dialogBox.center();
						closeButton.setFocus(true);
					}
				});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);
		*/
	}
}
