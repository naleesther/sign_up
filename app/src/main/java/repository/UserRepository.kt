package repository

import com.nalenyi.workoutlog.api.ApiClient
import com.nalenyi.workoutlog.api.ApiInterface
import com.nalenyi.workoutlog.models.LoginRequest
import com.nalenyi.workoutlog.models.LoginResponse
import com.nalenyi.workoutlog.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient= ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest):Response<LoginResponse>
    =withContext(Dispatchers.IO){
      val response = apiClient.loginUser(loginRequest)
      return@withContext response
    }
    suspend fun makeUserRequest(registerRequest: RegisterRequest)
                = withContext(Dispatchers.IO){
            val response=apiClient.registerUser(registerRequest)
            return@withContext response
    }
}
