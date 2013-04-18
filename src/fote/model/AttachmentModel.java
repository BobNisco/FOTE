package fote.model;

import fote.entry.Attachment;

/**
 *
 * @author Bob Nisco
 */
public class AttachmentModel extends BaseModel {
    public AttachmentModel() {
        super("attachments", Attachment.class);
    }
}
