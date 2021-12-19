package ja.burhanrashid52.photoeditor

import ja.burhanrashid52.photoeditor.Graphic.buildGestureController
import ja.burhanrashid52.photoeditor.MultiTouchListener.setOnGestureControl
import ja.burhanrashid52.photoeditor.Graphic.rootView
import android.view.ViewGroup
import ja.burhanrashid52.photoeditor.MultiTouchListener
import ja.burhanrashid52.photoeditor.PhotoEditorViewState
import ja.burhanrashid52.photoeditor.GraphicManager
import ja.burhanrashid52.photoeditor.Graphic
import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import ja.burhanrashid52.photoeditor.MultiTouchListener.OnGestureControl
import ja.burhanrashid52.photoeditor.ViewType
import ja.burhanrashid52.photoeditor.R

/**
 * Created by Burhanuddin Rashid on 14/05/21.
 *
 * @author <https:></https:>//github.com/burhanrashid52>
 */
internal class Sticker(
    private val mPhotoEditorView: ViewGroup,
    private val mMultiTouchListener: MultiTouchListener,
    private val mViewState: PhotoEditorViewState,
    graphicManager: GraphicManager?
) : Graphic(mPhotoEditorView.context, graphicManager!!) {
    private var imageView: ImageView? = null
    fun buildView(desiredImage: Bitmap?) {
        imageView!!.setImageBitmap(desiredImage)
    }

    private fun setupGesture() {
        val onGestureControl = buildGestureController(mPhotoEditorView, mViewState)
        mMultiTouchListener.setOnGestureControl(onGestureControl)
        val rootView = rootView
        rootView.setOnTouchListener(mMultiTouchListener)
    }

    override val viewType: ViewType
        get() = ViewType.IMAGE
    override val layoutId: Int
        get() = R.layout.view_photo_editor_image

    override fun setupView(rootView: View?) {
        imageView = rootView!!.findViewById(R.id.imgPhotoEditorImage)
    }

    init {
        setupGesture()
    }
}