package kr.co.youhyun.a20200318_intent04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import kr.co.youhyun.a20200318_intent04.databinding.ActivityEditUserInfoBinding;

public class EditUserInfoActivity extends AppCompatActivity {

    ActivityEditUserInfoBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_user_info);

//        2. 프로필 수정화면에서 이름 입력하고 버튼 누르면 하면 종료 후 메인화면으로 복귀
//        3. 돌아온 메인화면에서 2에서 입력한 이름을 텍스트뷰에 반영
//        돌아가는 길에 데이터를 들고가야함 nameEdt에 적힌 String을

        binding.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 데이터 첨부만을 위한 Intent. 출발/도착점 설정 x
                Intent intent = new Intent();
                // 이름 입력칸에 적힌 내용을 String으로 변환해서 inputName이라는 이름표를 붙여 첨부
                intent.putExtra("inputName", binding.nameEdt.getText().toString());

                // 결과 입력 완료 신호 + 어떤 데이터가 들어있는지 intent 설정
                // RESULT_OK : 정말로 완료다! 명시 역할
                // => (명시 안할 때)기본값은 취소로 설정됨
                // => 완료해서 입력한 데이터는 intent 안에 들어있다고 명시
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
