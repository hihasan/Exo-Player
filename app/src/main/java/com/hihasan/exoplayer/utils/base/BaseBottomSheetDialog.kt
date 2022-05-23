package com.hihasan.exoplayer.utils.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.room.Room
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.SnackbarContentLayout
import com.hihasan.exoplayer.R
import com.hihasan.exoplayer.constant.DatabaseConstants

open class BaseBottomSheetDialog : BottomSheetDialogFragment(){
    var database: BaseDatabase? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = activity?.let {
            Room.databaseBuilder(it, BaseDatabase::class.java, DatabaseConstants.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
        }

    }

    companion object {
        @JvmStatic
        fun showToast(ctx: Context?, msg: String?) {
            Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()
        }

        fun removeSpecialCharacter(dirtyString: String): String {
            val re = Regex("[^A-Za-z0-9 ]")
            return re.replace(dirtyString, "")
        }

        fun showSnackBar(context: Context, message: String,view: View){
            val snackbar = Snackbar.make(view,message, Snackbar.LENGTH_SHORT)
            snackbar.setBackgroundTint(ContextCompat.getColor(context, R.color.colorPrimary))
            snackbar.setTextColor(ContextCompat.getColor(context,R.color.white))
            val textView = snackbar.view.findViewById(R.id.snackbar_action) as TextView
            textView.isAllCaps = false
            val imgClose = ImageView(context)
            imgClose.scaleType = ImageView.ScaleType.CENTER_INSIDE
            val layImageParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            imgClose.setImageResource(R.drawable.ic_cross_primary)
            (textView.parent as SnackbarContentLayout).addView(imgClose, layImageParams)
            imgClose.setOnClickListener { snackbar.dismiss() }
            snackbar.show()
        }

        fun showSnackBarAlert(context: Context, message: String,view: View){
            val snackbar = Snackbar.make(view,message, Snackbar.LENGTH_SHORT)
            snackbar.setBackgroundTint(ContextCompat.getColor(context,R.color.colorRed))
            snackbar.setTextColor(ContextCompat.getColor(context,R.color.white))
            val textView = snackbar.view.findViewById(R.id.snackbar_action) as TextView
            textView.isAllCaps = false
            val imgClose = ImageView(context)
            imgClose.scaleType = ImageView.ScaleType.CENTER_INSIDE
            val layImageParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            imgClose.setImageResource(R.drawable.ic_cross_primary)
            (textView.parent as SnackbarContentLayout).addView(imgClose, layImageParams)
            imgClose.setOnClickListener { snackbar.dismiss() }
            snackbar.show()
        }
    }
}