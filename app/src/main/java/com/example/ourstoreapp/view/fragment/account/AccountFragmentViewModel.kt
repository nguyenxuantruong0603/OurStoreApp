package com.example.ourstoreapp.view.fragment.account

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ourstoreapp.R
import com.example.ourstoreapp.util.UtilClass.showToast
import com.example.ourstoreapp.view.activity.account.LoginActivity
import com.google.android.material.bottomsheet.BottomSheetDialog

class AccountFragmentViewModel(
    private val context: Context,
    private val layoutInflater: LayoutInflater
) : ViewModel() {
    var fullName = MutableLiveData<String>().apply {
        value = "Jack Hughman"
    }
    var email = MutableLiveData<String>().apply {
        value = "Thewolverine0603@gmail.com"
    }

    fun onClickLogout() {
        val intent = Intent(context.applicationContext, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.putExtra("EXIT", true)
        context.startActivity(intent)
    }

    fun onClickPaymentMethod() {
        val dialog = BottomSheetDialog(context)
        val paymentSheet = layoutInflater.inflate(R.layout.bottom_sheet_payment, null)
        dialog.setContentView(paymentSheet)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val layoutCreditCard = paymentSheet.findViewById<LinearLayout>(R.id.layoutCreditCard)
        val layoutDebitCard = paymentSheet.findViewById<LinearLayout>(R.id.layoutDebitCard)
        val layoutCashPay = paymentSheet.findViewById<LinearLayout>(R.id.layoutCashPay)
        val imgVisa = paymentSheet.findViewById<ImageView>(R.id.imgVisa)
        val imgMaestro = paymentSheet.findViewById<ImageView>(R.id.imgMaestro)
        val imgDiscover = paymentSheet.findViewById<ImageView>(R.id.imgDiscover)
        val imgMasterCard = paymentSheet.findViewById<ImageView>(R.id.imgMasterCard)
        val tvAuthorize = paymentSheet.findViewById<TextView>(R.id.tvAuthorize)
        val imgClose = paymentSheet.findViewById<ImageView>(R.id.imgClose)
        val edtCardNumber = paymentSheet.findViewById<EditText>(R.id.edtCardNumber)
        val edtExpiryDate = paymentSheet.findViewById<EditText>(R.id.edtExpiryDate)
        val edtCardPassword = paymentSheet.findViewById<EditText>(R.id.edtCardPassword)

        layoutCreditCard.setOnClickListener {
            layoutCashPay.setBackgroundResource(0)
            layoutDebitCard.setBackgroundResource(0)
            layoutCreditCard.setBackgroundResource(R.drawable.background_button_choose_payment)
        }

        layoutDebitCard.setOnClickListener {
            layoutCashPay.setBackgroundResource(0)
            layoutDebitCard.setBackgroundResource(R.drawable.background_button_choose_payment)
            layoutCreditCard.setBackgroundResource(0)
        }

        layoutCashPay.setOnClickListener {
            layoutCashPay.setBackgroundResource(R.drawable.background_button_choose_payment)
            layoutDebitCard.setBackgroundResource(0)
            layoutCreditCard.setBackgroundResource(0)
        }

        imgVisa.setOnClickListener { showToast(context, "U choose pay with Visa") }
        imgMaestro.setOnClickListener { showToast(context, "U choose pay with Maestro") }
        imgDiscover.setOnClickListener { showToast(context, "U choose pay with Discover") }
        imgMasterCard.setOnClickListener { showToast(context, "U choose pay with Master Card") }

        imgClose.setOnClickListener { dialog.dismiss() }
        tvAuthorize.setOnClickListener {
            if (edtCardNumber.text.toString() == "" || edtExpiryDate.text.toString() == "" || edtCardPassword.text.toString() == "") {
                showToast(context, "You need to fill in all the information")
            } else {
                showToast(context, "Payment method confirmation successful")
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    fun onClickUpdateAccount() {
        val builder = AlertDialog.Builder(context)
        val view = layoutInflater.inflate(R.layout.dialog_update_account, null)
        builder.setView(view)
        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val edtYourFullNameUpdate: EditText = view.findViewById(R.id.edtYourFullNameUpdate)
        val edtYourEmailUpdate: EditText = view.findViewById(R.id.edtYourEmailUpdate)
        val tvChangeInfo: TextView = view.findViewById(R.id.tvChangeInfo)

        tvChangeInfo.setOnClickListener {
            if (edtYourEmailUpdate.text.toString() == "" || edtYourFullNameUpdate.text.toString() == "") {
                showToast(context, "Not be empty")
            } else if (!isValidEmail(edtYourEmailUpdate.text.toString())) {
                showToast(context, "Invalid Email")
            } else {
                showToast(context, "Change info success")

                fullName.postValue(edtYourFullNameUpdate.text.toString())
                email.postValue(edtYourEmailUpdate.text.toString())

                Log.e("DATA_UPDATE", fullName.value + " | " + email.value)
                Log.e(
                    "DATA_UPDATE2",
                    edtYourFullNameUpdate.text.toString() + " | " + edtYourEmailUpdate.text.toString()
                )
                dialog.dismiss()

            }
        }
        dialog.show()
    }

    fun onClickShowDetailAccount() {
        val builder = AlertDialog.Builder(context)
        val view = layoutInflater.inflate(R.layout.dialog_detail_account, null)
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        builder.setView(view)

        val layoutMoney = view.findViewById<LinearLayout>(R.id.layoutMoney)
        val layoutStar = view.findViewById<LinearLayout>(R.id.layoutStar)
        val layoutCart = view.findViewById<LinearLayout>(R.id.layoutCart)

        layoutCart.setOnClickListener { showToast(context,"You have 99 order has been paid") }
        layoutStar.setOnClickListener { showToast(context,"You have 3060 star") }
        layoutMoney.setOnClickListener { showToast(context,"Your balance is 16032000 Vnđ") }

        builder.create().show()

    }

    private fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target)
            .matches()
    }
}