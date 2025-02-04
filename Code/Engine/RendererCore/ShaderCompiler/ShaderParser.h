#pragma once

#include <Foundation/Strings/String.h>
#include <RendererCore/Declarations.h>

class ezPropertyAttribute;

class EZ_RENDERERCORE_DLL ezShaderParser
{
public:
  struct AttributeDefinition
  {
    ezString m_sType;
    ezHybridArray<ezVariant, 8> m_Values;
  };

  struct ParameterDefinition
  {
    const ezRTTI* m_pType = nullptr;
    ezString m_sType;
    ezString m_sName;

    ezHybridArray<AttributeDefinition, 4> m_Attributes;
  };

  struct EnumValue
  {
    ezHashedString m_sValueName;
    ezInt32 m_iValueValue = 0;
  };

  struct EnumDefinition
  {
    ezString m_sName;
    ezUInt32 m_uiDefaultValue = 0;
    ezHybridArray<EnumValue, 16> m_Values;
  };

  static void ParseMaterialParameterSection(
    ezStreamReader& inout_stream, ezHybridArray<ParameterDefinition, 16>& out_parameter, ezHybridArray<EnumDefinition, 4>& out_enumDefinitions);

  static void ParsePermutationSection(
    ezStreamReader& inout_stream, ezHybridArray<ezHashedString, 16>& out_permVars, ezHybridArray<ezPermutationVar, 16>& out_fixedPermVars);
  static void ParsePermutationSection(
    ezStringView sPermutationSection, ezHybridArray<ezHashedString, 16>& out_permVars, ezHybridArray<ezPermutationVar, 16>& out_fixedPermVars);

  static void ParsePermutationVarConfig(ezStringView sPermutationVarConfig, ezVariant& out_defaultValue, EnumDefinition& out_enumDefinition);
};
