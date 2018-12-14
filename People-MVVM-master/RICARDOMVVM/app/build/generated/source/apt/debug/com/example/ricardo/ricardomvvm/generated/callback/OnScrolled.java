package com.example.ricardo.ricardomvvm.generated.callback;
public final class OnScrolled implements com.example.ricardo.ricardomvvm.Utils.RecyclerViewBindingAdapters.OnScrolled {
    final Listener mListener;
    final int mSourceId;
    public OnScrolled(Listener listener, int sourceId) {
        mListener = listener;
        mSourceId = sourceId;
    }
    @Override
    public void onScrolled(android.support.v7.widget.RecyclerView callbackArg_0, int callbackArg_1, int callbackArg_2) {
        mListener._internalCallbackOnScrolled(mSourceId , callbackArg_0, callbackArg_1, callbackArg_2);
    }
    public interface Listener {
        void _internalCallbackOnScrolled(int sourceId , android.support.v7.widget.RecyclerView callbackArg_0, int callbackArg_1, int callbackArg_2);
    }
}