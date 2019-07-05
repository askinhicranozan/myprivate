import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import {WindowRef} from './window-ref'

@Injectable()
export class CommonUtil {
    
    constructor(private windowRef:WindowRef) {
        
    }
    
    getDomain(){
        let protocol = this.windowRef.nativeWindow.location.protocol;
        let hostname =  this.windowRef.nativeWindow.location.hostname;
        
        let domain = protocol+"//"+hostname;
        return domain;
    }
    
    getCrmApiHost(){
        if(environment.production){
            let crmApiHost = this.getDomain()+"/crmapi";
            console.log(crmApiHost);
            return crmApiHost;
            
        }else{
            return environment.API_HOST;
        }
    }
    
    getIsmApiHost(){
        if(environment.production){
            let ismApiHost = this.getDomain()+"/ismapi";
            console.log(ismApiHost);
            return ismApiHost;
            
        }else{
            return environment.ISM_API_HOST;
        }
    }
    
    getSolrHost(){
        if(environment.production){
            let solrHost = this.getDomain()+"/solr";
            console.log(solrHost);
            return solrHost;
            
        }else{
            return environment.SOLR_HOST;
        }
    }
    
    getEventImageRoot(){
        if(environment.production){
            let eventImageRoot = this.getDomain()+"/static/images/live/event/eventimages/";
            console.log(eventImageRoot);
            return eventImageRoot;
            
        }else{
            return environment.EVENT_IMAGE_ROOT;
        }
    }
    
    getGroupImageRoot(){
        if(environment.production){
            let groupImageRoot = this.getDomain()+"/static/images/live/event/groupimages/";
            console.log(groupImageRoot);
            return groupImageRoot;
            
        }else{
            return environment.GROUP_IMAGE_ROOT;
        }
    }
    
    getMemprogImageRoot(){
        if(environment.production){
            let memprogImageRoot = this.getDomain()+"/static/images/membercards/";
            console.log(memprogImageRoot);
            return memprogImageRoot;
            
        }else{
            return environment.MEMPROG_IMAGE_ROOT;
        }
    }
    
}
