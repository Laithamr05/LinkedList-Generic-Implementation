import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GUI<T> extends Application {
	private LinkedList<T> linkedList = new LinkedList<>();
	private TextArea outputArea;
	private TextField inputField;
	private ComboBox<String> operationComboBox;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("LinkedList");

		VBox root = new VBox(10);
		root.setPadding(new Insets(10));

		HBox controlBox = new HBox(5);
		String[] operations = { "Insert", "Delete Iteratively", "Delete Recursively", "Traverse Forward",
				"Traverse Backwards", "Search", "Delete All", "Size" };
		operationComboBox = new ComboBox<>(FXCollections.observableArrayList(operations));
		inputField = new TextField();
		Button executeButton = new Button("Execute");
		operationComboBox.setValue("Insert");
		executeButton.setOnAction(e -> executeOperation());

		controlBox.getChildren().addAll(operationComboBox, inputField, executeButton);

		outputArea = new TextArea();
		outputArea.setEditable(false);
		outputArea.setPrefHeight(300);

		root.getChildren().addAll(controlBox, outputArea);

		Scene scene = new Scene(root, 450, 350);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void executeOperation() {
		String operation = operationComboBox.getValue();
		String input = inputField.getText().trim();

		switch (operation) {
		case "Insert":
			linkedList.insert((T) input);
			outputArea.setText("Inserted: " + input);
			break;

		case "Delete Iteratively":
			linkedList.deleteIteratively((T) input);
			outputArea.setText("Deleted iteratively: " + input);
			break;

		case "Delete Recursively":
			linkedList.deleteRecursively((T) input);
			outputArea.setText("Deleted recursively: " + input);
			break;

		case "Traverse Forward":
			linkedList.traverseForward();
			outputArea.setText("Traversed Forward");
			break;

		case "Traverse Backwards":
			linkedList.traverseBackwards();
			outputArea.setText("Traversed Backwards");
			break;

		case "Search":
			boolean found = false;
			Node<String> current = linkedList.head;

			while (current != null) {
				if (current.data.equals(input)) {
					System.out.println("Entity Found: " + current.data);
					found = true;
					break;
				}
				current = current.next;
			}

			if (!found) {
				System.out.println("No entity found");
			}

			outputArea.setText("Searched for: " + input);
			break;

		case "Delete All":
			outputArea.setText("All nodes deleted");
			break;

		case "Size":
			int size = linkedList.size();
			outputArea.setText("List size: " + size);
			break;
		}

		inputField.clear();
	}
}