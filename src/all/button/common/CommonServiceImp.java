package all.button.common;

import all.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommonServiceImp implements CommonService{
	
	// 창 닫기 
	public void windowClose(ActionEvent event) {
		// TODO Auto-generated method stub
		// ActionEvent.getSource() -> 실제 이벤트 발생한 객체
		Parent p = (Parent) event.getSource();
		Stage s = (Stage) p.getScene().getWindow();
		s.close();
	}

	// 에러 메세지 박스 호출
	public void msgBox(String title, String subject, String content) {
		// TODO Auto-generated method stub
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(subject);
		alert.setContentText(content);
		alert.showAndWait();
	}
	
	// 비회원일 때 버튼 작동시 호출되는 오류
	public void errorView1(Parent root) {
		Stage membershipForm = new Stage();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/notLoginError.fxml"));

		root = null;

		try {
			root = loader.load();
			membershipForm.setScene(new Scene(root));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Controller ctrl = loader.getController();
		ctrl.setRoot(root);

		membershipForm.setTitle("Error");
		membershipForm.setResizable(false);
		membershipForm.setAlwaysOnTop(true);
		membershipForm.show();
	}
	
	// 검색창 비어있으면 호출되는 오류
	public void errorView2(Parent root) {
		// TODO Auto-generated method stub
		Stage membershipForm = new Stage();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/isEmptyError.fxml"));

		root = null;

		try {
			root = loader.load();
			membershipForm.setScene(new Scene(root));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Controller ctrl = loader.getController();
		ctrl.setRoot(root);

		membershipForm.setTitle("Error");
		membershipForm.setResizable(false);
		membershipForm.setAlwaysOnTop(true);
		membershipForm.show();
	}
}