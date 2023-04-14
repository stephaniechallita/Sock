package fr.inria.kairos.sock.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import fr.inria.kairos.sock.services.SockGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSockParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'IotSystem'", "'{'", "'currentTime'", "'ownedActor'", "','", "'}'", "'ownedResource'", "'Actor'", "'isSensible'", "'processTime'", "'periodTime'", "'currentProcessTime'", "'resource'", "'code'", "'Resource'", "'actor'", "'('", "')'", "'-'", "'MaliciousActor'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalSockParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSockParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSockParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSock.g"; }



     	private SockGrammarAccess grammarAccess;

        public InternalSockParser(TokenStream input, SockGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "IotSystem";
       	}

       	@Override
       	protected SockGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleIotSystem"
    // InternalSock.g:64:1: entryRuleIotSystem returns [EObject current=null] : iv_ruleIotSystem= ruleIotSystem EOF ;
    public final EObject entryRuleIotSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIotSystem = null;


        try {
            // InternalSock.g:64:50: (iv_ruleIotSystem= ruleIotSystem EOF )
            // InternalSock.g:65:2: iv_ruleIotSystem= ruleIotSystem EOF
            {
             newCompositeNode(grammarAccess.getIotSystemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIotSystem=ruleIotSystem();

            state._fsp--;

             current =iv_ruleIotSystem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIotSystem"


    // $ANTLR start "ruleIotSystem"
    // InternalSock.g:71:1: ruleIotSystem returns [EObject current=null] : ( () otherlv_1= 'IotSystem' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'currentTime' ( (lv_currentTime_5_0= ruleEInt ) ) )? (otherlv_6= 'ownedActor' otherlv_7= '{' ( (lv_ownedActor_8_0= ruleActor ) ) (otherlv_9= ',' ( (lv_ownedActor_10_0= ruleActor ) ) )* otherlv_11= '}' )? (otherlv_12= 'ownedResource' otherlv_13= '{' ( (lv_ownedResource_14_0= ruleResource ) ) (otherlv_15= ',' ( (lv_ownedResource_16_0= ruleResource ) ) )* otherlv_17= '}' )? otherlv_18= '}' ) ;
    public final EObject ruleIotSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_currentTime_5_0 = null;

        EObject lv_ownedActor_8_0 = null;

        EObject lv_ownedActor_10_0 = null;

        EObject lv_ownedResource_14_0 = null;

        EObject lv_ownedResource_16_0 = null;



        	enterRule();

        try {
            // InternalSock.g:77:2: ( ( () otherlv_1= 'IotSystem' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'currentTime' ( (lv_currentTime_5_0= ruleEInt ) ) )? (otherlv_6= 'ownedActor' otherlv_7= '{' ( (lv_ownedActor_8_0= ruleActor ) ) (otherlv_9= ',' ( (lv_ownedActor_10_0= ruleActor ) ) )* otherlv_11= '}' )? (otherlv_12= 'ownedResource' otherlv_13= '{' ( (lv_ownedResource_14_0= ruleResource ) ) (otherlv_15= ',' ( (lv_ownedResource_16_0= ruleResource ) ) )* otherlv_17= '}' )? otherlv_18= '}' ) )
            // InternalSock.g:78:2: ( () otherlv_1= 'IotSystem' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'currentTime' ( (lv_currentTime_5_0= ruleEInt ) ) )? (otherlv_6= 'ownedActor' otherlv_7= '{' ( (lv_ownedActor_8_0= ruleActor ) ) (otherlv_9= ',' ( (lv_ownedActor_10_0= ruleActor ) ) )* otherlv_11= '}' )? (otherlv_12= 'ownedResource' otherlv_13= '{' ( (lv_ownedResource_14_0= ruleResource ) ) (otherlv_15= ',' ( (lv_ownedResource_16_0= ruleResource ) ) )* otherlv_17= '}' )? otherlv_18= '}' )
            {
            // InternalSock.g:78:2: ( () otherlv_1= 'IotSystem' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'currentTime' ( (lv_currentTime_5_0= ruleEInt ) ) )? (otherlv_6= 'ownedActor' otherlv_7= '{' ( (lv_ownedActor_8_0= ruleActor ) ) (otherlv_9= ',' ( (lv_ownedActor_10_0= ruleActor ) ) )* otherlv_11= '}' )? (otherlv_12= 'ownedResource' otherlv_13= '{' ( (lv_ownedResource_14_0= ruleResource ) ) (otherlv_15= ',' ( (lv_ownedResource_16_0= ruleResource ) ) )* otherlv_17= '}' )? otherlv_18= '}' )
            // InternalSock.g:79:3: () otherlv_1= 'IotSystem' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'currentTime' ( (lv_currentTime_5_0= ruleEInt ) ) )? (otherlv_6= 'ownedActor' otherlv_7= '{' ( (lv_ownedActor_8_0= ruleActor ) ) (otherlv_9= ',' ( (lv_ownedActor_10_0= ruleActor ) ) )* otherlv_11= '}' )? (otherlv_12= 'ownedResource' otherlv_13= '{' ( (lv_ownedResource_14_0= ruleResource ) ) (otherlv_15= ',' ( (lv_ownedResource_16_0= ruleResource ) ) )* otherlv_17= '}' )? otherlv_18= '}'
            {
            // InternalSock.g:79:3: ()
            // InternalSock.g:80:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIotSystemAccess().getIotSystemAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getIotSystemAccess().getIotSystemKeyword_1());
            		
            // InternalSock.g:90:3: ( (lv_name_2_0= ruleEString ) )
            // InternalSock.g:91:4: (lv_name_2_0= ruleEString )
            {
            // InternalSock.g:91:4: (lv_name_2_0= ruleEString )
            // InternalSock.g:92:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getIotSystemAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIotSystemRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"fr.inria.kairos.sock.Sock.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getIotSystemAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalSock.g:113:3: (otherlv_4= 'currentTime' ( (lv_currentTime_5_0= ruleEInt ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalSock.g:114:4: otherlv_4= 'currentTime' ( (lv_currentTime_5_0= ruleEInt ) )
                    {
                    otherlv_4=(Token)match(input,13,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getIotSystemAccess().getCurrentTimeKeyword_4_0());
                    			
                    // InternalSock.g:118:4: ( (lv_currentTime_5_0= ruleEInt ) )
                    // InternalSock.g:119:5: (lv_currentTime_5_0= ruleEInt )
                    {
                    // InternalSock.g:119:5: (lv_currentTime_5_0= ruleEInt )
                    // InternalSock.g:120:6: lv_currentTime_5_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getIotSystemAccess().getCurrentTimeEIntParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_currentTime_5_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIotSystemRule());
                    						}
                    						set(
                    							current,
                    							"currentTime",
                    							lv_currentTime_5_0,
                    							"fr.inria.kairos.sock.Sock.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSock.g:138:3: (otherlv_6= 'ownedActor' otherlv_7= '{' ( (lv_ownedActor_8_0= ruleActor ) ) (otherlv_9= ',' ( (lv_ownedActor_10_0= ruleActor ) ) )* otherlv_11= '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalSock.g:139:4: otherlv_6= 'ownedActor' otherlv_7= '{' ( (lv_ownedActor_8_0= ruleActor ) ) (otherlv_9= ',' ( (lv_ownedActor_10_0= ruleActor ) ) )* otherlv_11= '}'
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_4); 

                    				newLeafNode(otherlv_6, grammarAccess.getIotSystemAccess().getOwnedActorKeyword_5_0());
                    			
                    otherlv_7=(Token)match(input,12,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getIotSystemAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalSock.g:147:4: ( (lv_ownedActor_8_0= ruleActor ) )
                    // InternalSock.g:148:5: (lv_ownedActor_8_0= ruleActor )
                    {
                    // InternalSock.g:148:5: (lv_ownedActor_8_0= ruleActor )
                    // InternalSock.g:149:6: lv_ownedActor_8_0= ruleActor
                    {

                    						newCompositeNode(grammarAccess.getIotSystemAccess().getOwnedActorActorParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_ownedActor_8_0=ruleActor();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIotSystemRule());
                    						}
                    						add(
                    							current,
                    							"ownedActor",
                    							lv_ownedActor_8_0,
                    							"fr.inria.kairos.sock.Sock.Actor");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSock.g:166:4: (otherlv_9= ',' ( (lv_ownedActor_10_0= ruleActor ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==15) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalSock.g:167:5: otherlv_9= ',' ( (lv_ownedActor_10_0= ruleActor ) )
                    	    {
                    	    otherlv_9=(Token)match(input,15,FOLLOW_8); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getIotSystemAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalSock.g:171:5: ( (lv_ownedActor_10_0= ruleActor ) )
                    	    // InternalSock.g:172:6: (lv_ownedActor_10_0= ruleActor )
                    	    {
                    	    // InternalSock.g:172:6: (lv_ownedActor_10_0= ruleActor )
                    	    // InternalSock.g:173:7: lv_ownedActor_10_0= ruleActor
                    	    {

                    	    							newCompositeNode(grammarAccess.getIotSystemAccess().getOwnedActorActorParserRuleCall_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_ownedActor_10_0=ruleActor();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getIotSystemRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"ownedActor",
                    	    								lv_ownedActor_10_0,
                    	    								"fr.inria.kairos.sock.Sock.Actor");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,16,FOLLOW_10); 

                    				newLeafNode(otherlv_11, grammarAccess.getIotSystemAccess().getRightCurlyBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            // InternalSock.g:196:3: (otherlv_12= 'ownedResource' otherlv_13= '{' ( (lv_ownedResource_14_0= ruleResource ) ) (otherlv_15= ',' ( (lv_ownedResource_16_0= ruleResource ) ) )* otherlv_17= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSock.g:197:4: otherlv_12= 'ownedResource' otherlv_13= '{' ( (lv_ownedResource_14_0= ruleResource ) ) (otherlv_15= ',' ( (lv_ownedResource_16_0= ruleResource ) ) )* otherlv_17= '}'
                    {
                    otherlv_12=(Token)match(input,17,FOLLOW_4); 

                    				newLeafNode(otherlv_12, grammarAccess.getIotSystemAccess().getOwnedResourceKeyword_6_0());
                    			
                    otherlv_13=(Token)match(input,12,FOLLOW_11); 

                    				newLeafNode(otherlv_13, grammarAccess.getIotSystemAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalSock.g:205:4: ( (lv_ownedResource_14_0= ruleResource ) )
                    // InternalSock.g:206:5: (lv_ownedResource_14_0= ruleResource )
                    {
                    // InternalSock.g:206:5: (lv_ownedResource_14_0= ruleResource )
                    // InternalSock.g:207:6: lv_ownedResource_14_0= ruleResource
                    {

                    						newCompositeNode(grammarAccess.getIotSystemAccess().getOwnedResourceResourceParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_ownedResource_14_0=ruleResource();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIotSystemRule());
                    						}
                    						add(
                    							current,
                    							"ownedResource",
                    							lv_ownedResource_14_0,
                    							"fr.inria.kairos.sock.Sock.Resource");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSock.g:224:4: (otherlv_15= ',' ( (lv_ownedResource_16_0= ruleResource ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalSock.g:225:5: otherlv_15= ',' ( (lv_ownedResource_16_0= ruleResource ) )
                    	    {
                    	    otherlv_15=(Token)match(input,15,FOLLOW_11); 

                    	    					newLeafNode(otherlv_15, grammarAccess.getIotSystemAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalSock.g:229:5: ( (lv_ownedResource_16_0= ruleResource ) )
                    	    // InternalSock.g:230:6: (lv_ownedResource_16_0= ruleResource )
                    	    {
                    	    // InternalSock.g:230:6: (lv_ownedResource_16_0= ruleResource )
                    	    // InternalSock.g:231:7: lv_ownedResource_16_0= ruleResource
                    	    {

                    	    							newCompositeNode(grammarAccess.getIotSystemAccess().getOwnedResourceResourceParserRuleCall_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_ownedResource_16_0=ruleResource();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getIotSystemRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"ownedResource",
                    	    								lv_ownedResource_16_0,
                    	    								"fr.inria.kairos.sock.Sock.Resource");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,16,FOLLOW_12); 

                    				newLeafNode(otherlv_17, grammarAccess.getIotSystemAccess().getRightCurlyBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            otherlv_18=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_18, grammarAccess.getIotSystemAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIotSystem"


    // $ANTLR start "entryRuleActor"
    // InternalSock.g:262:1: entryRuleActor returns [EObject current=null] : iv_ruleActor= ruleActor EOF ;
    public final EObject entryRuleActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActor = null;


        try {
            // InternalSock.g:262:46: (iv_ruleActor= ruleActor EOF )
            // InternalSock.g:263:2: iv_ruleActor= ruleActor EOF
            {
             newCompositeNode(grammarAccess.getActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActor=ruleActor();

            state._fsp--;

             current =iv_ruleActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActor"


    // $ANTLR start "ruleActor"
    // InternalSock.g:269:1: ruleActor returns [EObject current=null] : (this_Actor_Impl_0= ruleActor_Impl | this_MaliciousActor_1= ruleMaliciousActor ) ;
    public final EObject ruleActor() throws RecognitionException {
        EObject current = null;

        EObject this_Actor_Impl_0 = null;

        EObject this_MaliciousActor_1 = null;



        	enterRule();

        try {
            // InternalSock.g:275:2: ( (this_Actor_Impl_0= ruleActor_Impl | this_MaliciousActor_1= ruleMaliciousActor ) )
            // InternalSock.g:276:2: (this_Actor_Impl_0= ruleActor_Impl | this_MaliciousActor_1= ruleMaliciousActor )
            {
            // InternalSock.g:276:2: (this_Actor_Impl_0= ruleActor_Impl | this_MaliciousActor_1= ruleMaliciousActor )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            else if ( (LA6_0==30) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalSock.g:277:3: this_Actor_Impl_0= ruleActor_Impl
                    {

                    			newCompositeNode(grammarAccess.getActorAccess().getActor_ImplParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Actor_Impl_0=ruleActor_Impl();

                    state._fsp--;


                    			current = this_Actor_Impl_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSock.g:286:3: this_MaliciousActor_1= ruleMaliciousActor
                    {

                    			newCompositeNode(grammarAccess.getActorAccess().getMaliciousActorParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_MaliciousActor_1=ruleMaliciousActor();

                    state._fsp--;


                    			current = this_MaliciousActor_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActor"


    // $ANTLR start "entryRuleEString"
    // InternalSock.g:298:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalSock.g:298:47: (iv_ruleEString= ruleEString EOF )
            // InternalSock.g:299:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalSock.g:305:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalSock.g:311:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalSock.g:312:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalSock.g:312:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalSock.g:313:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSock.g:321:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleActor_Impl"
    // InternalSock.g:332:1: entryRuleActor_Impl returns [EObject current=null] : iv_ruleActor_Impl= ruleActor_Impl EOF ;
    public final EObject entryRuleActor_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActor_Impl = null;


        try {
            // InternalSock.g:332:51: (iv_ruleActor_Impl= ruleActor_Impl EOF )
            // InternalSock.g:333:2: iv_ruleActor_Impl= ruleActor_Impl EOF
            {
             newCompositeNode(grammarAccess.getActor_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActor_Impl=ruleActor_Impl();

            state._fsp--;

             current =iv_ruleActor_Impl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActor_Impl"


    // $ANTLR start "ruleActor_Impl"
    // InternalSock.g:339:1: ruleActor_Impl returns [EObject current=null] : ( () otherlv_1= 'Actor' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'isSensible' ( (lv_isSensible_5_0= ruleEInt ) ) )? (otherlv_6= 'processTime' ( (lv_processTime_7_0= ruleEInt ) ) )? (otherlv_8= 'periodTime' ( (lv_periodTime_9_0= ruleEInt ) ) )? (otherlv_10= 'currentProcessTime' ( (lv_currentProcessTime_11_0= ruleEInt ) ) )? (otherlv_12= 'resource' ( ( ruleEString ) ) )? (otherlv_14= 'code' ( (lv_code_15_0= ruleEString ) ) )? otherlv_16= '}' ) ;
    public final EObject ruleActor_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_isSensible_5_0 = null;

        AntlrDatatypeRuleToken lv_processTime_7_0 = null;

        AntlrDatatypeRuleToken lv_periodTime_9_0 = null;

        AntlrDatatypeRuleToken lv_currentProcessTime_11_0 = null;

        AntlrDatatypeRuleToken lv_code_15_0 = null;



        	enterRule();

        try {
            // InternalSock.g:345:2: ( ( () otherlv_1= 'Actor' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'isSensible' ( (lv_isSensible_5_0= ruleEInt ) ) )? (otherlv_6= 'processTime' ( (lv_processTime_7_0= ruleEInt ) ) )? (otherlv_8= 'periodTime' ( (lv_periodTime_9_0= ruleEInt ) ) )? (otherlv_10= 'currentProcessTime' ( (lv_currentProcessTime_11_0= ruleEInt ) ) )? (otherlv_12= 'resource' ( ( ruleEString ) ) )? (otherlv_14= 'code' ( (lv_code_15_0= ruleEString ) ) )? otherlv_16= '}' ) )
            // InternalSock.g:346:2: ( () otherlv_1= 'Actor' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'isSensible' ( (lv_isSensible_5_0= ruleEInt ) ) )? (otherlv_6= 'processTime' ( (lv_processTime_7_0= ruleEInt ) ) )? (otherlv_8= 'periodTime' ( (lv_periodTime_9_0= ruleEInt ) ) )? (otherlv_10= 'currentProcessTime' ( (lv_currentProcessTime_11_0= ruleEInt ) ) )? (otherlv_12= 'resource' ( ( ruleEString ) ) )? (otherlv_14= 'code' ( (lv_code_15_0= ruleEString ) ) )? otherlv_16= '}' )
            {
            // InternalSock.g:346:2: ( () otherlv_1= 'Actor' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'isSensible' ( (lv_isSensible_5_0= ruleEInt ) ) )? (otherlv_6= 'processTime' ( (lv_processTime_7_0= ruleEInt ) ) )? (otherlv_8= 'periodTime' ( (lv_periodTime_9_0= ruleEInt ) ) )? (otherlv_10= 'currentProcessTime' ( (lv_currentProcessTime_11_0= ruleEInt ) ) )? (otherlv_12= 'resource' ( ( ruleEString ) ) )? (otherlv_14= 'code' ( (lv_code_15_0= ruleEString ) ) )? otherlv_16= '}' )
            // InternalSock.g:347:3: () otherlv_1= 'Actor' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'isSensible' ( (lv_isSensible_5_0= ruleEInt ) ) )? (otherlv_6= 'processTime' ( (lv_processTime_7_0= ruleEInt ) ) )? (otherlv_8= 'periodTime' ( (lv_periodTime_9_0= ruleEInt ) ) )? (otherlv_10= 'currentProcessTime' ( (lv_currentProcessTime_11_0= ruleEInt ) ) )? (otherlv_12= 'resource' ( ( ruleEString ) ) )? (otherlv_14= 'code' ( (lv_code_15_0= ruleEString ) ) )? otherlv_16= '}'
            {
            // InternalSock.g:347:3: ()
            // InternalSock.g:348:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActor_ImplAccess().getActorAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getActor_ImplAccess().getActorKeyword_1());
            		
            // InternalSock.g:358:3: ( (lv_name_2_0= ruleEString ) )
            // InternalSock.g:359:4: (lv_name_2_0= ruleEString )
            {
            // InternalSock.g:359:4: (lv_name_2_0= ruleEString )
            // InternalSock.g:360:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getActor_ImplAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActor_ImplRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"fr.inria.kairos.sock.Sock.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getActor_ImplAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalSock.g:381:3: (otherlv_4= 'isSensible' ( (lv_isSensible_5_0= ruleEInt ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalSock.g:382:4: otherlv_4= 'isSensible' ( (lv_isSensible_5_0= ruleEInt ) )
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getActor_ImplAccess().getIsSensibleKeyword_4_0());
                    			
                    // InternalSock.g:386:4: ( (lv_isSensible_5_0= ruleEInt ) )
                    // InternalSock.g:387:5: (lv_isSensible_5_0= ruleEInt )
                    {
                    // InternalSock.g:387:5: (lv_isSensible_5_0= ruleEInt )
                    // InternalSock.g:388:6: lv_isSensible_5_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getActor_ImplAccess().getIsSensibleEIntParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_isSensible_5_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActor_ImplRule());
                    						}
                    						set(
                    							current,
                    							"isSensible",
                    							lv_isSensible_5_0,
                    							"fr.inria.kairos.sock.Sock.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSock.g:406:3: (otherlv_6= 'processTime' ( (lv_processTime_7_0= ruleEInt ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSock.g:407:4: otherlv_6= 'processTime' ( (lv_processTime_7_0= ruleEInt ) )
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_6); 

                    				newLeafNode(otherlv_6, grammarAccess.getActor_ImplAccess().getProcessTimeKeyword_5_0());
                    			
                    // InternalSock.g:411:4: ( (lv_processTime_7_0= ruleEInt ) )
                    // InternalSock.g:412:5: (lv_processTime_7_0= ruleEInt )
                    {
                    // InternalSock.g:412:5: (lv_processTime_7_0= ruleEInt )
                    // InternalSock.g:413:6: lv_processTime_7_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getActor_ImplAccess().getProcessTimeEIntParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_processTime_7_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActor_ImplRule());
                    						}
                    						set(
                    							current,
                    							"processTime",
                    							lv_processTime_7_0,
                    							"fr.inria.kairos.sock.Sock.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSock.g:431:3: (otherlv_8= 'periodTime' ( (lv_periodTime_9_0= ruleEInt ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSock.g:432:4: otherlv_8= 'periodTime' ( (lv_periodTime_9_0= ruleEInt ) )
                    {
                    otherlv_8=(Token)match(input,21,FOLLOW_6); 

                    				newLeafNode(otherlv_8, grammarAccess.getActor_ImplAccess().getPeriodTimeKeyword_6_0());
                    			
                    // InternalSock.g:436:4: ( (lv_periodTime_9_0= ruleEInt ) )
                    // InternalSock.g:437:5: (lv_periodTime_9_0= ruleEInt )
                    {
                    // InternalSock.g:437:5: (lv_periodTime_9_0= ruleEInt )
                    // InternalSock.g:438:6: lv_periodTime_9_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getActor_ImplAccess().getPeriodTimeEIntParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_periodTime_9_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActor_ImplRule());
                    						}
                    						set(
                    							current,
                    							"periodTime",
                    							lv_periodTime_9_0,
                    							"fr.inria.kairos.sock.Sock.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSock.g:456:3: (otherlv_10= 'currentProcessTime' ( (lv_currentProcessTime_11_0= ruleEInt ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalSock.g:457:4: otherlv_10= 'currentProcessTime' ( (lv_currentProcessTime_11_0= ruleEInt ) )
                    {
                    otherlv_10=(Token)match(input,22,FOLLOW_6); 

                    				newLeafNode(otherlv_10, grammarAccess.getActor_ImplAccess().getCurrentProcessTimeKeyword_7_0());
                    			
                    // InternalSock.g:461:4: ( (lv_currentProcessTime_11_0= ruleEInt ) )
                    // InternalSock.g:462:5: (lv_currentProcessTime_11_0= ruleEInt )
                    {
                    // InternalSock.g:462:5: (lv_currentProcessTime_11_0= ruleEInt )
                    // InternalSock.g:463:6: lv_currentProcessTime_11_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getActor_ImplAccess().getCurrentProcessTimeEIntParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_17);
                    lv_currentProcessTime_11_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActor_ImplRule());
                    						}
                    						set(
                    							current,
                    							"currentProcessTime",
                    							lv_currentProcessTime_11_0,
                    							"fr.inria.kairos.sock.Sock.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSock.g:481:3: (otherlv_12= 'resource' ( ( ruleEString ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSock.g:482:4: otherlv_12= 'resource' ( ( ruleEString ) )
                    {
                    otherlv_12=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getActor_ImplAccess().getResourceKeyword_8_0());
                    			
                    // InternalSock.g:486:4: ( ( ruleEString ) )
                    // InternalSock.g:487:5: ( ruleEString )
                    {
                    // InternalSock.g:487:5: ( ruleEString )
                    // InternalSock.g:488:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActor_ImplRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getActor_ImplAccess().getResourceResourceCrossReference_8_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSock.g:503:3: (otherlv_14= 'code' ( (lv_code_15_0= ruleEString ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalSock.g:504:4: otherlv_14= 'code' ( (lv_code_15_0= ruleEString ) )
                    {
                    otherlv_14=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_14, grammarAccess.getActor_ImplAccess().getCodeKeyword_9_0());
                    			
                    // InternalSock.g:508:4: ( (lv_code_15_0= ruleEString ) )
                    // InternalSock.g:509:5: (lv_code_15_0= ruleEString )
                    {
                    // InternalSock.g:509:5: (lv_code_15_0= ruleEString )
                    // InternalSock.g:510:6: lv_code_15_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getActor_ImplAccess().getCodeEStringParserRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_code_15_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActor_ImplRule());
                    						}
                    						set(
                    							current,
                    							"code",
                    							lv_code_15_0,
                    							"fr.inria.kairos.sock.Sock.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getActor_ImplAccess().getRightCurlyBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActor_Impl"


    // $ANTLR start "entryRuleResource"
    // InternalSock.g:536:1: entryRuleResource returns [EObject current=null] : iv_ruleResource= ruleResource EOF ;
    public final EObject entryRuleResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResource = null;


        try {
            // InternalSock.g:536:49: (iv_ruleResource= ruleResource EOF )
            // InternalSock.g:537:2: iv_ruleResource= ruleResource EOF
            {
             newCompositeNode(grammarAccess.getResourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleResource=ruleResource();

            state._fsp--;

             current =iv_ruleResource; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResource"


    // $ANTLR start "ruleResource"
    // InternalSock.g:543:1: ruleResource returns [EObject current=null] : ( () otherlv_1= 'Resource' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'actor' otherlv_5= '(' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* otherlv_9= ')' )? otherlv_10= '}' ) ;
    public final EObject ruleResource() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;



        	enterRule();

        try {
            // InternalSock.g:549:2: ( ( () otherlv_1= 'Resource' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'actor' otherlv_5= '(' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* otherlv_9= ')' )? otherlv_10= '}' ) )
            // InternalSock.g:550:2: ( () otherlv_1= 'Resource' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'actor' otherlv_5= '(' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* otherlv_9= ')' )? otherlv_10= '}' )
            {
            // InternalSock.g:550:2: ( () otherlv_1= 'Resource' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'actor' otherlv_5= '(' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* otherlv_9= ')' )? otherlv_10= '}' )
            // InternalSock.g:551:3: () otherlv_1= 'Resource' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'actor' otherlv_5= '(' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* otherlv_9= ')' )? otherlv_10= '}'
            {
            // InternalSock.g:551:3: ()
            // InternalSock.g:552:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getResourceAccess().getResourceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,25,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getResourceAccess().getResourceKeyword_1());
            		
            // InternalSock.g:562:3: ( (lv_name_2_0= ruleEString ) )
            // InternalSock.g:563:4: (lv_name_2_0= ruleEString )
            {
            // InternalSock.g:563:4: (lv_name_2_0= ruleEString )
            // InternalSock.g:564:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getResourceAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getResourceRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"fr.inria.kairos.sock.Sock.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getResourceAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalSock.g:585:3: (otherlv_4= 'actor' otherlv_5= '(' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* otherlv_9= ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==26) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalSock.g:586:4: otherlv_4= 'actor' otherlv_5= '(' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,26,FOLLOW_20); 

                    				newLeafNode(otherlv_4, grammarAccess.getResourceAccess().getActorKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getResourceAccess().getLeftParenthesisKeyword_4_1());
                    			
                    // InternalSock.g:594:4: ( ( ruleEString ) )
                    // InternalSock.g:595:5: ( ruleEString )
                    {
                    // InternalSock.g:595:5: ( ruleEString )
                    // InternalSock.g:596:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getResourceRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getResourceAccess().getActorActorCrossReference_4_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSock.g:610:4: (otherlv_7= ',' ( ( ruleEString ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==15) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalSock.g:611:5: otherlv_7= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_7=(Token)match(input,15,FOLLOW_3); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getResourceAccess().getCommaKeyword_4_3_0());
                    	    				
                    	    // InternalSock.g:615:5: ( ( ruleEString ) )
                    	    // InternalSock.g:616:6: ( ruleEString )
                    	    {
                    	    // InternalSock.g:616:6: ( ruleEString )
                    	    // InternalSock.g:617:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getResourceRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getResourceAccess().getActorActorCrossReference_4_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,28,FOLLOW_12); 

                    				newLeafNode(otherlv_9, grammarAccess.getResourceAccess().getRightParenthesisKeyword_4_4());
                    			

                    }
                    break;

            }

            otherlv_10=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getResourceAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResource"


    // $ANTLR start "entryRuleEInt"
    // InternalSock.g:645:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalSock.g:645:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalSock.g:646:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalSock.g:652:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalSock.g:658:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalSock.g:659:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalSock.g:659:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalSock.g:660:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalSock.g:660:3: (kw= '-' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==29) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalSock.g:661:4: kw= '-'
                    {
                    kw=(Token)match(input,29,FOLLOW_22); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleMaliciousActor"
    // InternalSock.g:678:1: entryRuleMaliciousActor returns [EObject current=null] : iv_ruleMaliciousActor= ruleMaliciousActor EOF ;
    public final EObject entryRuleMaliciousActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaliciousActor = null;


        try {
            // InternalSock.g:678:55: (iv_ruleMaliciousActor= ruleMaliciousActor EOF )
            // InternalSock.g:679:2: iv_ruleMaliciousActor= ruleMaliciousActor EOF
            {
             newCompositeNode(grammarAccess.getMaliciousActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaliciousActor=ruleMaliciousActor();

            state._fsp--;

             current =iv_ruleMaliciousActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaliciousActor"


    // $ANTLR start "ruleMaliciousActor"
    // InternalSock.g:685:1: ruleMaliciousActor returns [EObject current=null] : ( () otherlv_1= 'MaliciousActor' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'isSensible' ( (lv_isSensible_5_0= ruleEInt ) ) )? (otherlv_6= 'processTime' ( (lv_processTime_7_0= ruleEInt ) ) )? (otherlv_8= 'periodTime' ( (lv_periodTime_9_0= ruleEInt ) ) )? (otherlv_10= 'currentProcessTime' ( (lv_currentProcessTime_11_0= ruleEInt ) ) )? (otherlv_12= 'resource' ( ( ruleEString ) ) )? otherlv_14= '}' ) ;
    public final EObject ruleMaliciousActor() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_isSensible_5_0 = null;

        AntlrDatatypeRuleToken lv_processTime_7_0 = null;

        AntlrDatatypeRuleToken lv_periodTime_9_0 = null;

        AntlrDatatypeRuleToken lv_currentProcessTime_11_0 = null;



        	enterRule();

        try {
            // InternalSock.g:691:2: ( ( () otherlv_1= 'MaliciousActor' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'isSensible' ( (lv_isSensible_5_0= ruleEInt ) ) )? (otherlv_6= 'processTime' ( (lv_processTime_7_0= ruleEInt ) ) )? (otherlv_8= 'periodTime' ( (lv_periodTime_9_0= ruleEInt ) ) )? (otherlv_10= 'currentProcessTime' ( (lv_currentProcessTime_11_0= ruleEInt ) ) )? (otherlv_12= 'resource' ( ( ruleEString ) ) )? otherlv_14= '}' ) )
            // InternalSock.g:692:2: ( () otherlv_1= 'MaliciousActor' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'isSensible' ( (lv_isSensible_5_0= ruleEInt ) ) )? (otherlv_6= 'processTime' ( (lv_processTime_7_0= ruleEInt ) ) )? (otherlv_8= 'periodTime' ( (lv_periodTime_9_0= ruleEInt ) ) )? (otherlv_10= 'currentProcessTime' ( (lv_currentProcessTime_11_0= ruleEInt ) ) )? (otherlv_12= 'resource' ( ( ruleEString ) ) )? otherlv_14= '}' )
            {
            // InternalSock.g:692:2: ( () otherlv_1= 'MaliciousActor' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'isSensible' ( (lv_isSensible_5_0= ruleEInt ) ) )? (otherlv_6= 'processTime' ( (lv_processTime_7_0= ruleEInt ) ) )? (otherlv_8= 'periodTime' ( (lv_periodTime_9_0= ruleEInt ) ) )? (otherlv_10= 'currentProcessTime' ( (lv_currentProcessTime_11_0= ruleEInt ) ) )? (otherlv_12= 'resource' ( ( ruleEString ) ) )? otherlv_14= '}' )
            // InternalSock.g:693:3: () otherlv_1= 'MaliciousActor' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'isSensible' ( (lv_isSensible_5_0= ruleEInt ) ) )? (otherlv_6= 'processTime' ( (lv_processTime_7_0= ruleEInt ) ) )? (otherlv_8= 'periodTime' ( (lv_periodTime_9_0= ruleEInt ) ) )? (otherlv_10= 'currentProcessTime' ( (lv_currentProcessTime_11_0= ruleEInt ) ) )? (otherlv_12= 'resource' ( ( ruleEString ) ) )? otherlv_14= '}'
            {
            // InternalSock.g:693:3: ()
            // InternalSock.g:694:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMaliciousActorAccess().getMaliciousActorAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getMaliciousActorAccess().getMaliciousActorKeyword_1());
            		
            // InternalSock.g:704:3: ( (lv_name_2_0= ruleEString ) )
            // InternalSock.g:705:4: (lv_name_2_0= ruleEString )
            {
            // InternalSock.g:705:4: (lv_name_2_0= ruleEString )
            // InternalSock.g:706:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getMaliciousActorAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMaliciousActorRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"fr.inria.kairos.sock.Sock.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_23); 

            			newLeafNode(otherlv_3, grammarAccess.getMaliciousActorAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalSock.g:727:3: (otherlv_4= 'isSensible' ( (lv_isSensible_5_0= ruleEInt ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==19) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSock.g:728:4: otherlv_4= 'isSensible' ( (lv_isSensible_5_0= ruleEInt ) )
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getMaliciousActorAccess().getIsSensibleKeyword_4_0());
                    			
                    // InternalSock.g:732:4: ( (lv_isSensible_5_0= ruleEInt ) )
                    // InternalSock.g:733:5: (lv_isSensible_5_0= ruleEInt )
                    {
                    // InternalSock.g:733:5: (lv_isSensible_5_0= ruleEInt )
                    // InternalSock.g:734:6: lv_isSensible_5_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getMaliciousActorAccess().getIsSensibleEIntParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_24);
                    lv_isSensible_5_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMaliciousActorRule());
                    						}
                    						set(
                    							current,
                    							"isSensible",
                    							lv_isSensible_5_0,
                    							"fr.inria.kairos.sock.Sock.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSock.g:752:3: (otherlv_6= 'processTime' ( (lv_processTime_7_0= ruleEInt ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==20) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalSock.g:753:4: otherlv_6= 'processTime' ( (lv_processTime_7_0= ruleEInt ) )
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_6); 

                    				newLeafNode(otherlv_6, grammarAccess.getMaliciousActorAccess().getProcessTimeKeyword_5_0());
                    			
                    // InternalSock.g:757:4: ( (lv_processTime_7_0= ruleEInt ) )
                    // InternalSock.g:758:5: (lv_processTime_7_0= ruleEInt )
                    {
                    // InternalSock.g:758:5: (lv_processTime_7_0= ruleEInt )
                    // InternalSock.g:759:6: lv_processTime_7_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getMaliciousActorAccess().getProcessTimeEIntParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_processTime_7_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMaliciousActorRule());
                    						}
                    						set(
                    							current,
                    							"processTime",
                    							lv_processTime_7_0,
                    							"fr.inria.kairos.sock.Sock.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSock.g:777:3: (otherlv_8= 'periodTime' ( (lv_periodTime_9_0= ruleEInt ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==21) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalSock.g:778:4: otherlv_8= 'periodTime' ( (lv_periodTime_9_0= ruleEInt ) )
                    {
                    otherlv_8=(Token)match(input,21,FOLLOW_6); 

                    				newLeafNode(otherlv_8, grammarAccess.getMaliciousActorAccess().getPeriodTimeKeyword_6_0());
                    			
                    // InternalSock.g:782:4: ( (lv_periodTime_9_0= ruleEInt ) )
                    // InternalSock.g:783:5: (lv_periodTime_9_0= ruleEInt )
                    {
                    // InternalSock.g:783:5: (lv_periodTime_9_0= ruleEInt )
                    // InternalSock.g:784:6: lv_periodTime_9_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getMaliciousActorAccess().getPeriodTimeEIntParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_26);
                    lv_periodTime_9_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMaliciousActorRule());
                    						}
                    						set(
                    							current,
                    							"periodTime",
                    							lv_periodTime_9_0,
                    							"fr.inria.kairos.sock.Sock.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSock.g:802:3: (otherlv_10= 'currentProcessTime' ( (lv_currentProcessTime_11_0= ruleEInt ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==22) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalSock.g:803:4: otherlv_10= 'currentProcessTime' ( (lv_currentProcessTime_11_0= ruleEInt ) )
                    {
                    otherlv_10=(Token)match(input,22,FOLLOW_6); 

                    				newLeafNode(otherlv_10, grammarAccess.getMaliciousActorAccess().getCurrentProcessTimeKeyword_7_0());
                    			
                    // InternalSock.g:807:4: ( (lv_currentProcessTime_11_0= ruleEInt ) )
                    // InternalSock.g:808:5: (lv_currentProcessTime_11_0= ruleEInt )
                    {
                    // InternalSock.g:808:5: (lv_currentProcessTime_11_0= ruleEInt )
                    // InternalSock.g:809:6: lv_currentProcessTime_11_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getMaliciousActorAccess().getCurrentProcessTimeEIntParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_currentProcessTime_11_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMaliciousActorRule());
                    						}
                    						set(
                    							current,
                    							"currentProcessTime",
                    							lv_currentProcessTime_11_0,
                    							"fr.inria.kairos.sock.Sock.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSock.g:827:3: (otherlv_12= 'resource' ( ( ruleEString ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==23) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalSock.g:828:4: otherlv_12= 'resource' ( ( ruleEString ) )
                    {
                    otherlv_12=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getMaliciousActorAccess().getResourceKeyword_8_0());
                    			
                    // InternalSock.g:832:4: ( ( ruleEString ) )
                    // InternalSock.g:833:5: ( ruleEString )
                    {
                    // InternalSock.g:833:5: ( ruleEString )
                    // InternalSock.g:834:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMaliciousActorRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getMaliciousActorAccess().getResourceResourceCrossReference_8_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_14=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getMaliciousActorAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaliciousActor"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000036000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000020000040L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000034000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000040040000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001F90000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001F10000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001E10000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001C10000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001810000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004010000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010008000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000F90000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000F10000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000E10000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000C10000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000810000L});

}