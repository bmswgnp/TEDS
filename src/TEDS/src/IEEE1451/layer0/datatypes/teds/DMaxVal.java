package IEEE1451.layer0.datatypes.teds;

import IEEE1451.layer0.datatypes.UInt8;
import IEEE1451.layer0.messages.EncodeOctetStream;

public class DMaxVal extends DataBlock {
	
	private String value;

    private DMaxVal(){
        super(DataBlock.MAX_VAL);
        value = new String();
    }

    public DMaxVal(String val) throws Exception {
        this();
        value = val;
    }

    public DMaxVal(DataBlock db, UInt8[] args) throws Exception{
        this();
        value = new String(UInt8.getArray(args));
    }

    public String getDescription(){
        return value;
    }    

	public UInt8[] getOctetArray() {
		try {
            EncodeOctetStream stream = new EncodeOctetStream(this);
            UInt8[] octets = UInt8.getArray(value.getBytes());
            for (int i = 0; i < octets.length; i++) {
                stream.addUInt8(octets[i]);
             }

            return stream.getOctetsArray();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
	}


	public int getLength() {
		return value.getBytes().length;
	}

}
