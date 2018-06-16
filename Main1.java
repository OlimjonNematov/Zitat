import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main1 extends Application
{

	public static void main (String[] args) 
	{
		// TODO Auto-generated method stub
		launch(args);	
		
	}
	public QuoteDB q = new QuoteDB();
	public Stage w;
	public Scene main;
	@SuppressWarnings("static-access")
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
//stages
	w= new Stage();
	w.setTitle("ZITAT!");
	w.setHeight(500);
	w.setWidth(500);
	BorderPane bp= new BorderPane();
	VBox tns=new VBox();
	VBox centerVBox= new VBox();
	HBox qod= new HBox();
	HBox bot= new HBox();
//modify panes
		tns.setAlignment(Pos.CENTER);
		qod.setAlignment(Pos.CENTER);
		qod.setSpacing(15);
		bot.setAlignment(Pos.CENTER);
		bot.setSpacing(150);
		centerVBox.setAlignment(Pos.CENTER);
//Title n slogan
		Label Title= new Label("Zitat");
		Label slogan= new Label("A Quote that Floats your Boat");
		Title.setId("title");
		slogan.setId("slogan");
//Quote of the day
		Label qodL= new Label("Quote of the Moment:");
		qodL.setMaxWidth(150);
		Label qodT= new Label();
		qodT.setMaxWidth(350);
		qodT.setWrapText(true);
		String qodText= q.AllQuotes.get((int)(Math.random()*((q.AllQuotes.size()-1)))).text;
		qodT.setText(qodText);
//bottom pane
		Button add= new Button("ADD");
		Button search= new Button("SEARCH");
		add.setOnAction(e ->{
			w.setScene(add());
		});
		search.setOnAction(e  ->{
			w.setScene(search());
		});
// get children
		tns.getChildren().addAll(Title,slogan);
		qod.getChildren().addAll(qodL,qodT);
		bot.getChildren().addAll(add,search);
		bp.setTop(tns);
		bp.setCenter(qod);
		bp.setBottom(bot);
		bp.setAlignment(Title, Pos.CENTER);
		
//setting up stage
		main= new Scene(bp);
		main.getStylesheets().add("venice.css");
		w.setScene(main);
		w.show();
		
		
		
	//animations
		TranslateTransition t= new TranslateTransition();
		t.setDuration(Duration.seconds(1));
		t.setToY(20);
		t.setAutoReverse(true);
		t.setNode(Title);
		t.play();
		
	/*	
		
			else if(action.equals("2")) 
			{
				System.out.println("Type 'c' if you would like to find quote by a catagory and 'a' to find a quote by author ");
				String act2= scan.nextLine();;
				if(act2.equals("c"))
				{
					System.out.println("What catagory would u like to search?");
					String Cat= scan.nextLine();
					System.out.println(q.find(Cat));
				}
				else if(act2.equals("a")) 
				{
					System.out.println("What Author would u like to search?");
					String aut= scan.nextLine();
					System.out.println(q.finda(aut));
				}
			}		
		//*/
					
	}
//_______________________________________________________________________________
	@SuppressWarnings({ "unchecked", "static-access" })
	private Scene search() {
//panes
		BorderPane searchM= new BorderPane();	
		HBox searchHB= new HBox(5);
		VBox searchVB= new VBox(25);
//controls
		Label prompt= new Label("Search by: ");
		Label allQuotes=new Label();
		//dropdown menu
				ObservableList<String> opts= 
					FXCollections.observableArrayList(
						"Author",
						"Category",
						"date"
					);
		@SuppressWarnings("rawtypes")
		ComboBox options= new ComboBox(opts);
		options.getSelectionModel().selectFirst();
		TextField KeyW= new TextField();
		Button searchB= new Button("ZITAT IT!");
		Label TitleS= new Label("select what you want to search by");
		Button Backs= new Button("<-");
//set on action
		searchB.setOnAction(e ->{
			if(options.getSelectionModel().getSelectedItem().equals("Author")) {
				allQuotes.setText(q.finda(KeyW.getText()));
			}
			else if(options.getSelectionModel().getSelectedItem().equals("Category")) {
				allQuotes.setText(q.find(KeyW.getText()));
			}
			else{
				allQuotes.setText(q.findy(KeyW.getText()));
			}
			
		});
		Backs.setOnAction(e ->{
			w.setScene(main);
		});
//get children

		searchHB.getChildren().addAll(prompt,options,KeyW);
		searchVB.getChildren().addAll(searchHB,searchB,allQuotes);
		searchM.setCenter(searchVB);
//		searchM.setTop(TitleS);
		searchM.setBottom(Backs);
//modify 
		allQuotes.setWrapText(true);
		searchVB.setAlignment(Pos.CENTER);
		searchHB.setAlignment(Pos.CENTER);
		searchM.setAlignment(searchVB, Pos.CENTER);
		searchM.setAlignment(TitleS, Pos.CENTER);
		searchM.setAlignment(Backs,Pos.BOTTOM_LEFT);
//set up scene
		Scene searchS= new Scene(searchM);
		searchS.getStylesheets().add("venice.css");
		return searchS;
	}
	
//_______________________________________________________________________________
	@SuppressWarnings("static-access")
	private Scene add() {
		BorderPane addM= new BorderPane();
		VBox inputs=new VBox(5);
		HBox inc= new HBox(5);
		HBox ina= new HBox(15);
		HBox inq= new HBox(18);
		HBox iny= new HBox(28);
		GridPane gdAddC= new GridPane();
//title
		Label addTitle= new Label("Add a Quote");
		addTitle.setId("title2");
//added label
		Label addedL=new Label("\t\tYour Quote has been Zitated");
//bottom butts
		Button AddIt= new Button("Add");
		AddIt.setShape(new Circle(3));
		Button Back=new Button("<-");
//input fields
		Label promptc= new Label("\tCatagory:");
		Label prompta= new Label("\tAuthor:");
		Label promptq= new Label("\tQuote:");
		Label prompty= new Label("\tYear:");
		
		TextField tfc= new TextField();
		TextField tfa= new TextField();
		TextField tfq= new TextField();
		TextField tfy= new TextField();
//setOn actions
		AddIt.setOnAction(e ->{
			if((!tfc.getText().equals(""))&&(!tfq.getText().equals("")&&(!tfa.getText().equals("")&&(!tfy.getText().equals("")))))
			{
				addedL.setText("\tYour quote has been zitated");
				q.add(tfc.getText(), tfq.getText(), tfa.getText(), tfy.getText());
				gdAddC.add(addedL, 2,0);
				tfc.setText("");
				tfq.setText("");
				tfa.setText("");
				tfy.setText("");
			}
			else {
				addedL.setText("please make sure that all the Fields have been filled");
				addedL.setWrapText(true);
				gdAddC.add(addedL, 0, 1);
			}
		});
		Back.setOnAction(e ->{
			w.setScene(main);
		});
//modify the pans
		gdAddC.setAlignment(Pos.CENTER);
		inc.setSpacing(5);
		ina.setSpacing(15);
		inq.setSpacing(18);
		iny.setSpacing(28);
		inputs.setAlignment(Pos.CENTER);
		addM.setAlignment(inputs,Pos.CENTER);
		addM.setAlignment(addTitle, Pos.BOTTOM_CENTER);		
//get children
		gdAddC.add(inputs, 0, 0);
		inc.getChildren().addAll(promptc ,tfc);
		ina.getChildren().addAll(prompta ,tfa);
		inq.getChildren().addAll(promptq ,tfq);
		iny.getChildren().addAll(prompty ,tfy);
		inputs.getChildren().addAll(inc,ina,inq,iny,AddIt);
		addM.setTop(addTitle);
		addM.setCenter(gdAddC);
		addM.setBottom(Back);
		Scene addS= new Scene(addM,500,500);
		addS.getStylesheets().add("venice.css");
		return addS;
	}
}

