package br.com.bancotoyota.services.sharepoint.docs.util;

import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.Files;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.Folders;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.ListItemAllFields;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.Metadata;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.ParentFolder;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.Properties;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.SharePointResponse;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.SharePointResponseBody;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.StorageMetrics;

public class TestDataFactory {
	public static SharePointResponse criarRespostaApiSharePoint() {
		SharePointResponse spr = new SharePointResponse();
		SharePointResponseBody sprb = new SharePointResponseBody();
		sprb.setExists(true);
		sprb.setFilesObject(new Files());
		sprb.setFoldersObject(new Folders());
		sprb.setItemCount(1);
		sprb.setListItemAllFieldsObject(new ListItemAllFields());
		sprb.setMetadataObject(new Metadata());
		sprb.setName("corporativo");
		sprb.setParentFolderObject(new ParentFolder());
		sprb.setProgID("1");
		sprb.setPropertiesObject(new Properties());
		sprb.setServerRelativeUrl("");
		sprb.setStorageMetricsObject(new StorageMetrics());
		sprb.setTimeCreated(" ");
		sprb.setTimeLastModified(" ");
		sprb.setUniqueId(" ");
		sprb.setWelcomePage(" ");
		sprb.setWOPIEnabled(true);
		spr.setResponse(sprb);
		spr.setResponse(sprb);
		return spr;
	}

}
