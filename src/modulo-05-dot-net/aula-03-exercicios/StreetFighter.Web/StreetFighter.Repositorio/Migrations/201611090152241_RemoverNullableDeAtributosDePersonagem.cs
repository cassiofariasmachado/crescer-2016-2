namespace StreetFighter.Repositorio.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class RemoverNullableDeAtributosDePersonagem : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Personagem", "Altura", c => c.Int(nullable: false));
            AlterColumn("dbo.Personagem", "Peso", c => c.Double(nullable: false));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Personagem", "Peso", c => c.Double());
            AlterColumn("dbo.Personagem", "Altura", c => c.Int());
        }
    }
}
