package geometris.controllers;


public class BlockContext {
    private BlockType blockType;
    public BlockContext(BlockType blockType) {
        this.blockType = blockType;
    }

    public float getPositionX() {
        return blockType.getPositionX();
    }

    public float getPositionY() {
        return blockType.getPositionY();
    }
}
