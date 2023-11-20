package com.example.editor;

import com.example.core.ResourceManager.ResourceHandle;
import com.example.core.System.Window;
import com.example.editorEngineProcessFramework.EditorEngineProcessFrameworkDLL;
import com.example.foundation.Configuration.Singleton;
import com.example.foundation.Types.UniquePtr;
import com.example.rendererCore.Pipeline.Declarations;

public class EzActor {}

// Assume que ezTypedResourceHandle é definido de forma semelhante a ResourceHandle
class EzRenderPipelineResourceHandle extends ResourceHandle<EzRenderPipelineResource> {}

enum EzEditorEngineProcessMode {
    Primary,
    Remote
}

class EzRemoteProcessWindow extends Window {}

@EditorEngineProcessFrameworkDLL
public class EzEditorEngineProcessApp {
    private static EzEditorEngineProcessApp instance;

    public static EzEditorEngineProcessApp getInstance() {
        if (instance == null) {
            instance = new EzEditorEngineProcessApp();
        }
        return instance;
    }

    private EzEditorEngineProcessApp() {}

    public void setRemoteMode() {
        m_Mode = EzEditorEngineProcessMode.Remote;
    }

    public boolean isRemoteMode() {
        return m_Mode == EzEditorEngineProcessMode.Remote;
    }

    public EzViewHandle createRemoteWindowAndView(EzCamera pCamera) {
        return createRemoteWindow(); // Change this to return actual value
    }

    public void destroyRemoteWindow() {}

    public EzRenderPipelineResourceHandle createDefaultMainRenderPipeline() {
        return null; // Implement this method as needed
    }

    public EzRenderPipelineResourceHandle createDefaultDebugRenderPipeline() {
        return null; // Implement this method as needed
    }

    protected EzViewHandle createRemoteWindow() {
        return null; // Implement this method as needed
    }

    private EzEditorEngineProcessMode m_Mode = EzEditorEngineProcessMode.Primary;
    private EzActor m_pActor = null;
    private EzViewHandle m_hRemoteView = null;
}
