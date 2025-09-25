// MainActivity.kt

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
// UserRequestDto, UserResponseDto, RetrofitClient는 실제 파일이 있는 패키지 경로를 import 해야 합니다.
// 예: import com.teamjm.tabacco_spot_server.dto.UserRequestDto
private fun sendUserToServer(user: UserRequestDto) {
    val call = RetrofitClient.instance.saveUser(user)

    call.enqueue(object : Callback<UserResponseDto> {
        override fun onResponse(call: Call<UserResponseDto>, response: Response<UserResponseDto>) {
            if (response.isSuccessful) {
                // 성공 토스트 메시지와 로그 확인
                val savedUser = response.body()
                Toast.makeText(this@MainActivity, "사용자 저장 성공! ID: ${savedUser?.id}", Toast.LENGTH_SHORT).show()
                Log.d("API_SUCCESS", "저장된 사용자 정보: $savedUser")
            } else {
                // 실패 로그 확인
                Log.e("API_ERROR", "오류 코드: ${response.code()}, 메시지: ${response.errorBody()?.string()}")
            }
        }

        override fun onFailure(call: Call<UserResponseDto>, t: Throwable) {
            // 네트워크 실패 로그 확인
            Log.e("API_FAILURE", "네트워크 오류: ${t.message}")
        }
    })
}