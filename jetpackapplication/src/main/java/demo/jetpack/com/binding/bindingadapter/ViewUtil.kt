package demo.jetpack.com.binding.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class ViewUtil {
    companion object {
        @JvmStatic
        @BindingAdapter(value = ["imageUrl", "placeHolder"], requireAll = false)
        fun showVendorImage(imageView: ImageView, imageUrl: String, placeholder: Int) {
            if (imageUrl.isNullOrBlank()) {
                imageView.setImageResource(placeholder)
            } else {
                Picasso.get().load(imageUrl).into(imageView)
            }
        }
    }
}