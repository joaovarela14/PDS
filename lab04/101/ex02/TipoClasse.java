

public enum TipoClasse {
  EXECUTIVA,
  TURISTICA,
  NONE;

  public static TipoClasse getTipoByChar(char c){
    
    switch (Character.toUpperCase(c)) {
      case 'E':
        return EXECUTIVA;
      case 'T':
        return TURISTICA;
      default:
        return NONE;
    }
  }
}
