package com.example.ourstoreapp.view.activity.account

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Patterns
import androidx.lifecycle.*
import com.example.ourstoreapp.datamodel.user.User
import com.example.ourstoreapp.datamodel.user.UserRepository
import com.example.ourstoreapp.util.UtilClass.showToast
import com.example.ourstoreapp.view.activity.HomeActivity
import kotlinx.coroutines.launch

class AccountViewModel(val context: Context, private val userRepository: UserRepository) :
    ViewModel() {

    var usernameLogin = MutableLiveData<String>().apply { value = "truongnx" }
    var passwordLogin = MutableLiveData<String>().apply { value = "Xtruong" }
    var usernameRegister = MutableLiveData<String>()
    var passwordRegister = MutableLiveData<String>()
    var emailRegister = MutableLiveData<String>()
    var listUser: List<User> = listOf()

    // get all user from Room Database
    private val listFood: LiveData<List<User>> = userRepository.listAllUser.asLiveData()

    init {
        listFood
    }

    fun clickLogin() {
        if (usernameLogin.value == null || passwordLogin.value == null || usernameLogin.value == "" || passwordLogin.value == "") {
            showToast(context, "Not be empty")
        } else {
            for (user in 0..5) {
                if (usernameLogin.value == "truongnx" && passwordLogin.value == "Xtruong") {
                    showToast(context, "Login Success")
                    context.startActivity(Intent(context, HomeActivity::class.java))
                    break
                }
            }

            showToast(context, "Username or password incorrect")

        }
    }

    fun clickLoginGoogle() {
        showToast(context, "Login With Google")
    }

    fun clickLoginFacebook() {
        showToast(context, "Login With Facebook")
    }

    fun clickSignUp() {

        if (usernameRegister.value == null || passwordRegister.value == null || emailRegister.value == null) {
            showToast(context, "Not be empty")
        } else if (usernameRegister.value == "" || passwordRegister.value == "" || emailRegister.value == "") {
            showToast(context, "Not be empty")
        } else if (passwordRegister.value!!.length < 6) {
            showToast(context, "Password must be more than 6 characters")
        } else if (!isValidEmail(emailRegister.value)) {
            showToast(context, "Invalid Email")
        } else {
            insertUser(
                User(
                    usernameRegister.value!!,
                    passwordRegister.value!!,
                    emailRegister.value!!
                )
            )
            showToast(context, "Register Successfully")
        }
    }

    private fun insertUser(user: User) = viewModelScope.launch { userRepository.insert(user) }

    private fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target)
            .matches()
    }


    class AccountViewModelFactory(val context: Context, private val repository: UserRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AccountViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return AccountViewModel(context, repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}







